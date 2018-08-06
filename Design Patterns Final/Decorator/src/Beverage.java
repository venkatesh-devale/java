public abstract class Beverage {
    protected String description;

    public Beverage() {
        description = "Unknown Beverage";
    }

    protected abstract String getDescription();
    protected abstract Double cost();
}
