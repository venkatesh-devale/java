public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend";
    }

    @Override
    protected String getDescription() {
        return description;
    }

    @Override
    protected Double cost() {
        return 0.89;
    }
}
