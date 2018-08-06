public class PremiumToppings extends BurgerDecorator {
    private String[] options;

    public PremiumToppings(String d) {
        super(d);
    }

    public void setOptions(String[] o) {
        this.options = o;
        if(o.length > 0) {
            this.price += (o.length ) * 1.50;
        }
    }

    public String getDescription() {
        String temp = "";
        for(int i = 0; i < this.options.length; i++ ) {
            if(i>0)
                temp += " + " + options[i];
            else
                temp = options[i];
        }
        return temp;
    }

    public void printDescription() {
        System.out.println(this.getDescription());
    }
}
