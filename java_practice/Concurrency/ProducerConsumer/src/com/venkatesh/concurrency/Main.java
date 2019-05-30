package com.venkatesh.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        Producer producer = new Producer(buffer);

        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class Producer implements Runnable{
    private List<String> buffer;
    private Random random = new Random();
    private String[] str = {
            "1", "2", "3", "4", "5"
    };

    Producer(List<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(String s: str) {
            System.out.println("Adding "+s);
            synchronized (buffer) {
                buffer.add(s);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    System.out.println("Producer was interrupted");
                }
            }
        }
        System.out.println("Adding EOF...");
        synchronized (buffer) {
            buffer.add("EOF");
        }

    }
}

class Consumer implements Runnable{
    private List<String> buffer;
    private Random random = new Random();

    Consumer(List<String> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                if(buffer.isEmpty())
                    continue;

                if(buffer.get(0).equals("EOF")) {
                    break;
                }

                else {
                    System.out.println("Removing "+buffer.get(0));
                    buffer.remove(0);
                }
            }

        }


    }
}


