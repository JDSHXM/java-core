package Lesson12.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        /* 1)
        Создай Predicate<String>, который проверяет, что строка не пуста и длиннее 3 символов.
        * */
        //task_1();

        /* 2)
        Создай Function<String, Integer>, возвращающую длину строки.
        * */
        //task_2();

        /* 3)
        Создай Supplier<UUID>, который возвращает новый UUID при каждом вызове.
        * */
        //task_3();

        /* 4)
        Создай Consumer<String>, который выводит строку в upper case.
        * */
        //task_4();

        /* 5)
        Создай BiFunction<Integer, Integer, Integer>, которая возвращает сумму двух чисел.
        * */
        //task_5();

        /* 6)
        Function<String, String> trim и Function<String, String> toUpperCase.
        Объедини их в одну, которая сначала обрезает пробелы, потом делает верхний регистр.
        * */
        //task_6();

        /* 7)
        Один Consumer печатает строку в консоль, второй — печатает длину строки. Объедини их через andThen().
        * */
        //task_7();

        /* 8)
        Создай Predicate<Integer> isEven и isPositive. Получи Predicate, который проверяет "нечётное или отрицательное".
        * */
        //task_8();

        /* 9)
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        Используй andThen(), чтобы объединить в одну цепочку.
        * */
        //task_9();

        /* 10)
        Создай UnaryOperator<String>, который добавляет "!!!" к строке.
        * */
        //task_10();

        /* 11)
        Создай метод filter(List<T> list, Predicate<T> predicate),
        который вручную фильтрует коллекцию аналогично Stream API.
        * */
        //task_11();

        /* 12)
        Создай метод map(List<T> list, Function<T, R> mapper) и преобразуй List<String> в List<Integer> (длины строк).
        * */
        //task_12();

        /* 13)
        Создай метод forEach(List<T> list, Consumer<T> consumer) и напечатай каждый элемент списка.
        * */
        //task_13();

        /* 14)
        Напиши метод generate(Supplier<T> supplier, int n),
        который создаёт список из n элементов, полученных от supplier.
        * */
        //task_14();

    }

    public static void task_1() {
        Predicate<String> isValid = str -> str != null && !str.isEmpty() && str.length() > 3;

        System.out.println(isValid.test("Salom"));
        System.out.println(isValid.test("Hi"));
        System.out.println(isValid.test(""));
        System.out.println(isValid.test(null));
    }

    public static void task_2() {
        Function<String, Integer> stringLength = str -> str.length();

        // Проверим работу
        System.out.println(stringLength.apply("Dima"));
        System.out.println(stringLength.apply("Jumanazarov"));
    }

    public static void task_3() {
        Supplier<UUID> uuidSupplier = () -> UUID.randomUUID();

        System.out.println(uuidSupplier.get());
        System.out.println(uuidSupplier.get());
        System.out.println(uuidSupplier.get());
    }

    public static void task_4() {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("uzum market");
        printUpperCase.accept("Uzum Bank — надежный цифровой банк Узбекистана");
    }

    public static void task_5() {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(5, 7));
        System.out.println(sum.apply(10, 20));
    }

    public static void task_6() {
        Function<String, String> trim = str -> str.trim();
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<String, String> trimAndUpper = trim.andThen(toUpperCase);

        System.out.println(trimAndUpper.apply("   mama   "));
        System.out.println(trimAndUpper.apply("   mohirdev "));
    }

    public static void task_7() {
        Consumer<String> printString = str -> System.out.println("Строка: " + str);
        Consumer<String> printLength = str -> System.out.println("Длина: " + str.length());
        Consumer<String> combined = printString.andThen(printLength);
        combined.accept("Java");
        combined.accept("Functional Interface");
    }

    public static void task_8() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isOddOrNegative = isEven.negate().or(isPositive.negate());

        System.out.println(isOddOrNegative.test(5));
        System.out.println(isOddOrNegative.test(-2));
        System.out.println(isOddOrNegative.test(4));
        System.out.println(isOddOrNegative.test(-3));
    }

    public static void task_9() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> multiplyAndToStr = multiply.andThen(toStr);

        System.out.println(multiplyAndToStr.apply(3, 5));
        System.out.println(multiplyAndToStr.apply(7, 2));
    }

    public static void task_10() {
        UnaryOperator<String> addExclamation = str -> str + "!!!";

        System.out.println(addExclamation.apply("Bobur"));
        System.out.println(addExclamation.apply("Anatoliy"));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            boolean testPassed = condition.test(item);
            if (testPassed) {
                result.add(item);
            }
        }
        return result;
    }
    public static void task_11() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> evenNumbers = filter(numbers, isEven);
        System.out.println("Четные числа:: " + evenNumbers);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            R newValue = mapper.apply(item);
            result.add(newValue);
        }
        return result;
    }
    public static void task_12() {
        List<String> words = new ArrayList<>();
        words.add("Java");
        words.add("Code");
        words.add("Stream");
        words.add("API");

        Function<String, Integer> getLength = word -> word.length();
        List<Integer> lengths = map(words, getLength);

        System.out.println("Слова: " + words);
        System.out.println("Их длины: " + lengths);
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }
    public static void task_13() {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Functional");
        names.add("Interface");
        Consumer<String> printItem = str -> System.out.println(str);
        forEach(names, printItem);
    }

    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            T value = supplier.get();
            result.add(value);
        }
        return result;
    }
    public static void task_14() {
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 100);
        List<Integer> numbers = generate(randomNumber, 5);
        System.out.println("Случайные числа: " + numbers);
    }

}