public class ConcreteHandler1 implements Handler {
    Handler nextHandler = null;

    @Override
    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if(request.equalsIgnoreCase("R1")) {
            System.out.println("Concrete Handler 1 is handling the request");
        }
        else {
            System.out.println("Could not handle the request, forwarding to next handler");
            nextHandler.handleRequest(request);
        }
    }
}
