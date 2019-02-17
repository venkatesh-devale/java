import java.util.Random;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new WriterClass(message)).start();
        new Thread(new ReaderClass(message)).start();
    }
}

class Message {
    private boolean empty = true;
    private String message;

    public synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
    
}

 class WriterClass implements Runnable {
    private Message message;
    Random random = new Random();
    String strArray[] = {
        "Multithreading is heavy",
        "Node seems better",
        "Java is great"
    };

    public WriterClass(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i=0;i<strArray.length;i++) {
            message.write(strArray[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e) {

            }
            
        }
        message.write("Finished writing messages...");
    }
}

 class ReaderClass implements Runnable {
    private Message message;
    Random random = new Random();
    public ReaderClass(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(String temp = message.read(); !temp.equals("Finished");temp = message.read()) {
        
            System.out.println(temp);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e) {
    
            }
        }
        
    }
}