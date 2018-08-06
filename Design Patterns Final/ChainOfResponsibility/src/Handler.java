public interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(String request);
}
