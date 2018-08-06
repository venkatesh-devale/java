public class Light {
    private String description;

    public Light(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(description + " light is switched on...");
    }

    public void off() {
        System.out.println(description + " light is switched off...");
    }

}
