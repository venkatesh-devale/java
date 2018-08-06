public class Mocha extends Decorator {
    Beverage beverage;

    public Mocha(Beverage b) {
        this.beverage = b;
    }

    @Override
    protected String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    protected Double cost() {
        return beverage.cost() + .20;
    }
}
