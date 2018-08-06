public abstract class BurgerDecorator extends Leaf implements IBurger{

    private String description;

    IBurger burger;

    public BurgerDecorator(String d) {
        super(d);
    }

    public void setDecorator(IBurger b) {
        this.burger = b;
    }



    @Override
    public Double getPrice() {
        if(this.burger == null) {
            return this.price;
        } else
            return this.price + this.burger.getPrice();
    }
}
