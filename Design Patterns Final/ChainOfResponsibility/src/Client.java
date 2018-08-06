public class Client {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();

        h1.setNextHandler(h2);

        h1.handleRequest("R1");
        h1.handleRequest("R2");
        h1.handleRequest("R3");
    }
}
