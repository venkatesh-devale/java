public class Toppings extends BurgerDecorator {
    private String[] options;

    public Toppings(String d) {
        super(d);
    }

    public void setOptions(String[] o) {
        this.options = o;
        if(o.length > 4) {
            this.price += (o.length - 4) * 0.75;
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
