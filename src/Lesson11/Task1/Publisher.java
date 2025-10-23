package Lesson11.Task1;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class  Publisher implements Runnable {
    private BlockingQueue<String> queue;
    private Scanner scanner;

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Publisher запущен. Введите слово ('exit' - для выхода):");
        while (true) {
            String message = scanner.nextLine();
            try {
                queue.put(message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Publisher был прерван.");
            }
        }
        scanner.close();
    }
}