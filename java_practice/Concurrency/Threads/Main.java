/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from Main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("---Another Thread---");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println("Hello from anonymous class");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnableThread(){
            @Override
            public void run() {
                System.out.println("Hello from anonymous class thread from MyRunnableThread");
            }
        });

        myRunnableThread.start();
        System.out.println("Hello again from Main thread");
    }
}