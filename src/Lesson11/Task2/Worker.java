package Lesson11.Task2;

import java.util.concurrent.BlockingQueue;

public class Worker extends Thread {

    private final BlockingQueue<Runnable> taskQueue;
    private final SimpleThreadPool pool;

    public Worker(String name, BlockingQueue<Runnable> taskQueue, SimpleThreadPool pool) {
        super(name);
        this.taskQueue = taskQueue;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (pool.isRunning() || !taskQueue.isEmpty()) {
            try {
                Runnable task = taskQueue.take();
                System.out.println(getName() + " выполняет задачу...");
                task.run();
            } catch (InterruptedException e) {
                if (!pool.isRunning()) break;
            }
        }
        System.out.println(getName() + " завершил работу.");
    }
}