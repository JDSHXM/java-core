package Lesson8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ПРОГРАММА ЭЛЕКТРОННОЙ ОЧЕРЕДИ ===");
        UserQueue queue = new UserQueue();

        queue.addUser("Aziza");
        queue.addUser("Jovohir");
        queue.addUser("Malika");
        queue.showQueue();

        queue.processNextUser();
        queue.showQueue();

        System.out.println();

        System.out.println("Введите набор чисел через пробел (например: 1 2 3 45 5):");
        String input = scanner.nextLine();

        String[] parts = input.split("\\s+");
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String s : parts) {
            try {
                uniqueNumbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Пропущено некорректное значение: " + s);
            }
        }

        System.out.println("Уникальные числа: " + uniqueNumbers);
        System.out.println();

        System.out.println("=== СПИСОК КНИГ ===");
        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("4569852", new Book("Java для начинающих", "Dilmurod Jumanazarov", "4569852"));
        bookMap.put("145236", new Book("Effective Java", "Atabaev Bobur", "145236"));
        bookMap.put("369852", new Book("Clean Code", "Isoqov Azamat", "369852"));

        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
        scanner.close();
    }
}
