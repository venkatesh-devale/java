public class ConcreteHandler2 implements Handler {
    Handler nextHandler = null;

    @Override
    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if(request.equalsIgnoreCase("R2")) {
            System.out.println("Concrete Handler 2 is handling the request");
        }
        else {
            if(nextHandler == null)
                System.out.println("No handler for the request, thrashing request out!");
        }
    }
}

