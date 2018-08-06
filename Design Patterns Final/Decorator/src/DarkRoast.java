public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    protected String getDescription() {
        return description;
    }

    @Override
    protected Double cost() {
        return 0.99;
    }

}
