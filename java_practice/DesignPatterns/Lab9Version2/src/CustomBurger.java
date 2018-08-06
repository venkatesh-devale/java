public class CustomBurger extends Composite {

    IBurger burger;


    public CustomBurger(String d) {
        super(d);
    }

    public void printDescription() {
        System.out.println( description + " " + this.burger.getPrice());
        for (Component obj  : components)
        {
            obj.printDescription();
        }
    }

    public void setDecorator(IBurger b) {
        this.burger = b;
    }

}
