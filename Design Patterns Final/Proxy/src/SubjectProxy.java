public interface SubjectProxy {
    void readData(String authToken);
    void writeData(String authToken, String data);
}
