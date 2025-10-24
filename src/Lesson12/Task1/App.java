package Lesson12.Task1;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
                /*       Я выполнил эти задачи двумя способами:
                         через цикл for и через Stream API,
                         выделив для каждого отдельные методы.
                */
    /* 1)
    Дан список чисел. Оставь только чётные и выведи их квадраты.
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    * */
    //task1_1();  // for
    //    System.out.println();
    //task1_2();  // Stream API

    /* 2)
    Подсчитай, сколько строк в списке длиннее 5 символов.
    List<String> words = List.of("apple", "banana", "pear", "pineapple");
    * */
    //task2_1();
    //    System.out.println();
    //task2_2();

    /* 3)
    Найди максимальное и минимальное число в списке с помощью Stream API.
    List<Integer> nums = List.of(10, 2, 33, 4, 25);
    * */
    //task3_1();
    //    System.out.println();
    //task3_2();

    /* 4)
    Посчитай среднюю длину строк в списке.
    List<String> names = List.of("Alice", "Bob", "Charlie", "David");
    * */
    //task4_1();
    //    System.out.println();
    //task4_2();

    /* 5)
    Удали дубликаты и отсортируй строки по длине.
    List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
    * */
    //task5_1();
    //    System.out.println();
    //task5_2();

    /* 6)
    Преобразуй список строк в Map: ключ — строка, значение — длина.
    List<String> fruits = List.of("apple", "banana", "kiwi");
    * */
    //task6_1();
    //    System.out.println();
    //task6_2();

    /* 7)
    Сгруппируй имена по первой букве.
    List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
    * */
    //task7_1();
    //    System.out.println();
    //task7_2();

    /* 8)
    Собери список имён в одну строку через запятую.
    List<String> names = List.of("Tom", "Jerry", "Spike");
    * */
    //task8_1();
    //    System.out.println();
    //task8_2();

    /*
    Из списка предложений получить список всех слов.
    List<String> sentences = List.of("Java is cool", "Streams are powerful");
    * */
    //task9_1();
    //    System.out.println();
    //task9_2();

    /*
    Найди самый дорогой продукт в каждой категории.
    record Product(String name, String category, double price) {}
    List<Product> products = List.of(
        new Product("Phone", "Electronics", 1200),
        new Product("TV", "Electronics", 1800),
        new Product("Apple", "Fruits", 2.5),
        new Product("Mango", "Fruits", 4.0));
    * */
    //task10_1();
    //    System.out.println();
    //task10_2();

    }

    public static void task1_1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number * number + " ");
            }
        }
    }
    public static void task1_2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
    }

    public static void task2_1() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        int count = 0;
        for (String word : words) {
            if (word.length() > 5) {
                count++;
            }
        }
        System.out.println("Количество слов длиннее 5 символов: " + count);
    }
    public static void task2_2() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        long count = words.stream()
                .filter(word -> word.length() > 5)
                .count();
        System.out.println("Количество слов длиннее 5 символов: " + count);
    }

    public static void task3_1() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int min = nums.get(0);
        int max = nums.get(0);

        for (Integer n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число" + max);
    }
    public static void task3_2() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int min = nums.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow();

        int max = nums.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
    }

    public static void task4_1() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        int totalLength = 0;

        for (String name : names) {
            totalLength += name.length();
        }

        double average = (double) totalLength / names.size();

        System.out.println("Средняя длина: " + average);
    }
    public static void task4_2() {

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double average = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        System.out.println("Средняя длина:" + average);
    }

    public static void task5_1() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        Set<String> unique = new HashSet<>(input);
        List<String> result = new ArrayList<>(unique);
        result.sort(Comparator.comparingInt(String::length));
        System.out.println(result);
    }
    public static void task5_2() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> result = input.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void task6_1(){
        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = new HashMap<>();
        for (String fruit : fruits) {
            map.put(fruit, fruit.length());
        }
        System.out.println(map);
    }
    public static void task6_2(){
        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        fruit -> fruit.length()
                ));
        System.out.println(map);
    }

    public static void task7_1(){
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> grouped = new HashMap<>();
        for (String name : names) {
            char firstLetter = name.charAt(0);
            grouped.putIfAbsent(firstLetter, new ArrayList<>());
            grouped.get(firstLetter).add(name);
        }
        System.out.println(grouped);
    }
    public static void task7_2(){
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(grouped);
    }

    public static void task8_1(){
        List<String> names = List.of("Tom", "Jerry", "Spike");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            result.append(names.get(i));
            if (i < names.size() - 1) {
                result.append(", ");
            }
        }
        System.out.println("Результат: " + result);
    }
    public static void task8_2(){
        List<String> names = List.of("Tom", "Jerry", "Spike");
        String result = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Результат: " + result);
    }

    public static void task9_1() {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            String[] parts = sentence.split(" ");
            for (String word : parts) {
                words.add(word);
            }
        }
        System.out.println(words);
    }
    public static void task9_2() {
            List<String> sentences = List.of("Java is cool", "Streams are powerful");
            List<String> words = sentences.stream()
                    .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                    .collect(Collectors.toList());
            System.out.println(words);
    }

    public static void task10_1(){
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0)
        );
        Map<String, Product> mostExpensive = new HashMap<>();
        for (Product p : products) {
            Product current = mostExpensive.get(p.category());
            if (current == null || p.price() > current.price()) {
                mostExpensive.put(p.category(), p);
            }
        }
        for (Map.Entry<String, Product> entry : mostExpensive.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    public static void task10_2(){
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0)
        );
        Map<String, Product> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Product::price)),
                                Optional::get
                        )
                ));
        mostExpensive.forEach((category, product) ->
                System.out.println(category + " -> " + product));
    }
}