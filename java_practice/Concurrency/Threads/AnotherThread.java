/**
 * AnotherThread
 */
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello from "+ currentThread().getName() + " thread");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Another thread interrupted me");
        }

        System.out.println("I woke up after 3000 milliseconds");
    }
    
}