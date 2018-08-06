public class SteamedMilk extends Decorator {
    Beverage beverage;

    public SteamedMilk(Beverage b) {
        this.beverage = b;
    }

    @Override
    protected String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    @Override
    protected Double cost() {
        return beverage.cost() + .10;
    }
}
