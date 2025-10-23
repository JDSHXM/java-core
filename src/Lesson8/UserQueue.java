package Lesson8;

import java.util.LinkedList;
import java.util.Queue;

public class UserQueue {
    private Queue<String> queue = new LinkedList<>();
    private int counter = 1;

    public void addUser(String name) {
        queue.add(name + " (№" + counter + ")");
        System.out.println("Пользователь " + name + " зарегистрирован. Его номер: " + counter);
        counter++;
    }

    public void processNextUser() {
        if (!queue.isEmpty()) {
            String processedUser = queue.poll();
            System.out.println("Заявка обработана: " + processedUser);
        } else {
            System.out.println("Очередь пуста!");
        }
    }

    public void showQueue() {
        System.out.println("Текущая очередь: " + queue);
    }
}
