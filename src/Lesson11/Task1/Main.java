package Lesson11.Task1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread publisherThread = new Thread(new Publisher(queue));
        Thread subscriberThread = new Thread(new Subscriber(queue));

        publisherThread.start();
        subscriberThread.start();

        try {
            publisherThread.join();
            subscriberThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Программа завершена.");
    }
}
