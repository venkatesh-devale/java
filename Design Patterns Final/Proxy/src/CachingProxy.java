public class CachingProxy implements SubjectProxy {

    private String dataCache = null;
    RealSubject realSubject = new RealSubject();

    @Override
    public void readData(String authToken) {

        if(dataCache == null) {
            System.out.println("No hit..reading data from server");
            dataCache = realSubject.getData();
        }
        else {
            System.out.println("Reading data from cache..." + dataCache);
        }

    }

    @Override
    public void writeData(String authToken, String data) {
        dataCache = data;
        realSubject.writeData(data);
    }
}
