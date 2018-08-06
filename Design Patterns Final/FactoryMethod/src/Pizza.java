public abstract class Pizza {
    String name;

    public void prepare() {
        System.out.println("Preparing the " + name);
    }

    public void bake() {
        System.out.println("Baking for 25 mins");
    }

    public void cut() {
        System.out.println("Cutting into diagonal pieces");
    }

    public void box() {
        System.out.println("Pizza is boxed to serve");
    }

    public String getName() {
        return name;
    }



}
