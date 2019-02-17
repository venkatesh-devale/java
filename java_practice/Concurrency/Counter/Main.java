/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}

class Countdown {
    private int i;

    public void doCountDown() {
        synchronized(this) {
            for(i=10;i>0;i--) 
            System.out.println("Thread " + Thread.currentThread().getName() + " printing counter: " + i);
        }
        
    }
    
}

class CountdownThread extends Thread {
    
    private Countdown countDown;

    public CountdownThread(Countdown countdown) {
        this.countDown = countdown;
    }

    @Override
    public void run() {
        countDown.doCountDown();
    }
}