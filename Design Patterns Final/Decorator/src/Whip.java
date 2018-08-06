public class Whip extends Decorator {
    Beverage beverage;

    public Whip(Beverage b) {
        this.beverage = b;
    }

    @Override
    protected String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    protected Double cost() {
        return beverage.cost() + .10;
    }
}
