public class Soy extends Decorator {
    Beverage beverage;

    public Soy(Beverage b) {
        this.beverage = b;
    }

    @Override
    protected String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    protected Double cost() {
        return beverage.cost() + .15;
    }
}
