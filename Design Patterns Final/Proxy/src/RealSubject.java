public class RealSubject {

    private String data = "Nothing to read first";

    public RealSubject() {

    }

    public void readData() {
        System.out.println("Reading data..." + data);
    }

    public void writeData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }



}
