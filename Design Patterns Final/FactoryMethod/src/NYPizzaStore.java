public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if(type.equalsIgnoreCase("cheese"))
            return new NYStyleCheesePizza();
        else
            return null;
    }
}
