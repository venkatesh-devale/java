public class Client {
    public static void main(String[] args) {
//        SubjectProxy accessProxy = new AccessProxy();
//        accessProxy.readData("abc");
//        accessProxy.writeData("abc", "12345678");
//        accessProxy.readData("abc");

        SubjectProxy cacheProxy = new CachingProxy();
        cacheProxy.readData("abc");
        cacheProxy.writeData("abc", "123");
        cacheProxy.readData("abc");
    }
}
