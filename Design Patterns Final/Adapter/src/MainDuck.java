public class MainDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

    @Override
    public void fly() {
        System.out.println("I am flying long");
    }
}
