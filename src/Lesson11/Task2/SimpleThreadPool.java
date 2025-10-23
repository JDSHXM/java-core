package Lesson11.Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleThreadPool {

    private final int threadCount;
    private final Worker[] workers;
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isRunning = true;
    public SimpleThreadPool(int threadCount) {
        this.threadCount = threadCount;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workers = new Worker[threadCount];


        for (int i = 0; i < threadCount; i++) {
            workers[i] = new Worker("Worker-" + (i + 1), taskQueue, this);
            workers[i].start();
        }

        System.out.println("Пул потоков создан: " + threadCount + " потоков.");
    }

    public void submit(Runnable task) {
        if (isRunning) {
            try {
                taskQueue.put(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            throw new IllegalStateException("Пул уже завершил работу!");
        }
    }


    public void shutdown() {
        isRunning = false;
        for (Worker worker : workers) {
            worker.interrupt();
        }
        System.out.println("Пул потоков завершает работу...");
    }

    public boolean isRunning() {
        return isRunning;
    }
}