package Lesson11.Task1;

import java.util.concurrent.BlockingQueue;

public class Subscriber implements Runnable {
    private BlockingQueue<String> queue;

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Subscriber запущен...");
        try {
            while (true) {
                String message = queue.take();
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Программа завершается...");
                    break;
                }
                System.out.println("Subscriber получил: " + message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Subscriber был прерван.");
        }
    }
}
