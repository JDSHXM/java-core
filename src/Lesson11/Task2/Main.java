package Lesson11.Task2;

public class Main {
    public static void main(String[] args) {

        SimpleThreadPool pool = new SimpleThreadPool(5);

        for (int i = 1; i <= 15; i++) {
            int taskNumber = i;
            pool.submit(() -> {
                System.out.println("Задача " + taskNumber + " выполняется в " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Задача " + taskNumber + " завершена.");
            });
        }


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        pool.shutdown();
    }
}
