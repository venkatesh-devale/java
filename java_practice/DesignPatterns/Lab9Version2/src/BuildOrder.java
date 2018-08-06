public class BuildOrder {
    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
        order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
        order.addChild(new Leaf("The Purist", 8.00 ));

        CustomBurger customBurger = new CustomBurger( "Build Your Own Burger" ) ;

        Burger b = new Burger("Burger Options");
        String[] boptions = {"Beef", "1/3lb.", "On A Bun"};
        b.setOptions(boptions);



        Cheese c = new Cheese("Cheese Options");
        String[] coptions = {"Danish Blue Cheese", "Horseradish Cheddar"};
        c.setOptions(coptions);
        c.setDecorator(b);

        Toppings t = new Toppings("Toppings Options");
        String[] toptions = {"Bermuda Red Onion", "Black Olives", "Carrot Strings", "Coleslaw"};
        t.setOptions(toptions);
        t.setDecorator(c);

        PremiumToppings pt = new PremiumToppings("Premium Toppings Options");
        String[] ptoptions = {"Applewood Smoked Bacon"};
        pt.setOptions(ptoptions);
        pt.setDecorator(t);

        Sauce s = new Sauce("Sauce Options");
        String[] soptions = {"Appricot Sauce"};
        s.setOptions(soptions);
        s.setDecorator(pt);

        customBurger.setDecorator(s);

        customBurger.addChild(b);
        customBurger.addChild(c);
        customBurger.addChild(t);
        customBurger.addChild(pt);
        customBurger.addChild(s);

//        customBurger.addChild(new Leaf("Beef, 1/3 lb on a Bun", 9.50 )); // base price for 1/3 lb
//        customBurger.addChild(new Leaf("Danish Blue Cheese", 0.00 )); // 1 cheese free, extra cheese +1.00
//        customBurger.addChild(new Leaf("Horseradish Cheddar", 1.00 )); // extra cheese +1.00
//        customBurger.addChild(new Leaf("Bermuda Red Onion", 0.00 )); // 4 toppings free, extra +.75
//        customBurger.addChild(new Leaf("Black Olives", 0.00 )); // 4 toppings free, extra +.75
//        customBurger.addChild(new Leaf("Carrot Strings", 0.00 )); // 4 toppings free, extra +.75
//        customBurger.addChild(new Leaf("Coleslaw", 0.00 )); // 4 toppings free, extra +.75
//        customBurger.addChild(new Leaf("Applewood Smoked Bacon", 1.50 )); // premium topping +1.50
//        customBurger.addChild(new Leaf("Appricot Sauce", 0.00 )); // 1 sauce free, extra +.75


        order.addChild( customBurger );
        return order ;
    }
}
