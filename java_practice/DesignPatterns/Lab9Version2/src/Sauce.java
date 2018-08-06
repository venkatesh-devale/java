public class Sauce extends BurgerDecorator {
    private String[] options;

    public Sauce(String d) {
        super(d);
    }

    public void setOptions(String[] o) {
        this.options = o;
        if(o.length > 1) {
            this.price += (o.length - 1) * 0.75;
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
