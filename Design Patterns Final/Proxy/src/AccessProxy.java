public class AccessProxy implements SubjectProxy {

    RealSubject realSubject = new RealSubject();

    @Override
    public void readData(String authToken) {
        if(authToken.equalsIgnoreCase("abc")) {
            System.out.println("Authenticated");
            realSubject.readData();
        }
        else {
            System.out.println("Could Not authenticate, cannot read any data");
        }
    }

    @Override
    public void writeData(String authToken, String data) {
        if(authToken.equalsIgnoreCase("abc")) {
            System.out.println("Authenticated");
            realSubject.writeData(data);
        }
        else {
            System.out.println("Could Not authenticate, cannot write any data");
        }
    }
}
