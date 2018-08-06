public class Burger extends BurgerDecorator{
    private String[] options;

    public Burger(String d) {
        super(d);
    }

    public void setOptions(String[] o) {
        this.options = o;
        for(int i = 0; i < o.length; i++) {
            if(("1/3lb.").equals(o[i])) {
                this.price += 9.50;
            }
            if(("2/3lb.").equals(o[i])) {
                this.price += 11.50;
            }
            if(("1lb.").equals(o[i])) {
                this.price += 15.50;
            }
            if(("In A Bowl").equals(o[i])) {
                this.price += 1.00;
            }
        }
    }

    public String getDescription() {
        String temp = "";
        for(int i = 0; i < this.options.length; i++ ) {
            if(i>0)
                temp += " + " + this.options[i];
            else
                temp = this.options[i];
        }
        return temp;
    }

    public void printDescription() {
        System.out.println(this.getDescription());
    }




}
