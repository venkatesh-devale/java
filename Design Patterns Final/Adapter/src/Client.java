public class Client {
    public static void main(String[] args) {
        Duck mainDuck = new MainDuck();
        testDuck(mainDuck);

        Turkey mainTurkey = new MainTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(mainTurkey);
        testDuck(turkeyAdapter);

    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
