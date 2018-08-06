public class TurkeyAdapter implements Duck {
    Turkey mainTurkey;

    public TurkeyAdapter(Turkey mainTurkey) {
        this.mainTurkey = mainTurkey;
    }

    @Override
    public void quack() {
        mainTurkey.gobble();
    }

    @Override
    public void fly() {
        mainTurkey.fly();
    }
}
