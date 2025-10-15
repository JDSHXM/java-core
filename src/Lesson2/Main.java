package Lesson2;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // Вывести числа от 1 до 100 (каждые 10 цифр в одну строку и каждую группу с новой строки)
        //printNumber();

        // Сумма чисел от 1 до N (ввод N с клавиатуры).
        //printSummaN();

        // Произведение чисел от 1 до N.
        //printSumN();

        // Сумма четных чисел от 1 до N.
        //printSummaEven();

        // Сумма цифр числа (например, 1234 → 10).
        //sumOfDigits();

        // Разворот числа (например, 1234 → 4321).
        //reverseNumber();

        // Найти факториал N (через цикл, не рекурсией).
        //factorial();

        // Найти первое число, которое делится на 7 и больше 1000.
        //findFirstDivisibleBy7();

        // Вывести все простые числа до N.
        //primeNumbers();

        /*Нарисовать треугольники из звездочек:
            *	****
            **	 ***
            ***	  **
            ****   *

            ****   *
            ***	  **
            **	 ***
            *	****
        */
        //printStar();

        /////////////////////////////////////////////////////////////////

        // Обмен значений *
        //Пользователь вводит два числа. Поменяйте их местами и выведите результат.
        //swapNumbers();

        //Таблица умножения *
        //Программа позволяет вывести на экран таблицу умножения для разных случаев.
        //multiplicationTable();

        //Конвертер валют *
        //Пусть курс доллара задан переменной exchange = 12500. Пользователь вводит сумму в долларах. Выведите сумму в сумах.
        //currencyConverter();

        //Чётное или нечётное *
        //Пользователь вводит число. Определите, четное оно или нет и выведите ответ на экран.
        //evenOrOdd();

        //Максимум из трёх *
        //Пользователь вводит 3 числа. Найдите и выведите наибольшее.
        //maxOfThree();

        //Калькулятор **
        //Пользователь вводит два числа и операцию (+, -, *, /). Выведите результат вычисления. Используйте if или switch.
        //calculator();

        //Среднее арифметическое **
        //Пользователь вводит n чисел (в массив). Найдите и выведите среднее значение.
        //averageValue();

        //Поиск элемента **
        //Пользователь вводит массив и число. Проверьте, есть ли это число в массиве.
        //findElement();

        //Мини-игра "Угадай число" **
        //Генерировать случайное число и дать игроку попытки угадать его.
        //guessNumberGame();

        /////////////////////////////////////////////////

        //Квест игра «Тень над Озером»
        questGame();





    }

    public static void printNumber(){
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%4d",i);
            if (i % 10 == 0){
                System.out.printf("\n");
            }
        }
    }

    public static void printSummaN(){
        System.out.print("Введите N - ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum +=i;
        }
        System.out.println("Sum = " + sum);
    }

    public static void printSumN(){
        System.out.print("Введите N - ");
        int n = scanner.nextInt();
        BigInteger sum = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Sum = " + sum);
    }

    public static void printSummaEven(){
        System.out.print("Введите число N: - ");
        int n = scanner.nextInt();
        int summa = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0){
                summa += i;
            }
        }
        System.out.println("Сумма чётных чисел от 1 до " + n + " = " + summa);
    }

    public static void sumOfDigits(){
        System.out.print("Введите число: N - ");
        int n = scanner.nextInt();
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("Сумма цифр = " + sum);
    }

    public static void reverseNumber(){
        // 1-й способ переворачивает число по цифрам, но убирает начальные нули;
        // 2-й способ работает со строкой и сохраняет нули.

        //1-й способ
        System.out.print("Введите число N - ");
        int n = scanner.nextInt();
        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        System.out.println("Обратное число: " + reversed);

        // 2-й способ
        scanner.nextLine();
        System.out.print("Введите число N - ");
        String s = scanner.nextLine(); // читаем число как строку
        // Переворачиваем строку с помощью StringBuilder
        String reversed1 = new StringBuilder(s).reverse().toString();
        System.out.println("Результат: " + reversed1);

    }

    public static void factorial(){
        System.out.print("Введите число N - ");
        int n = scanner.nextInt();

        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i)); // fact = fact * i
        }

        System.out.println("Факториал числа " + n + " = " + fact);
    }

    public static void findFirstDivisibleBy7(){
        int n = 1001; // начинаем с числа, большего 1000

        while (true) {
            if (n % 7 == 0) {
                System.out.println("Первое число, которое делится на 7 и больше 1000: " + n);
                break;
            }
            n++;
        }
    }

    public static void primeNumbers(){
        System.out.print("Введите число N - ");
        int n = scanner.nextInt();
        System.out.println("Простые числа до " + n + ":");

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

    public static void printStar(){
        int n = 4;

        //  1-фигура
        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
        System.out.println();
        //  2-фигура
        for (int i = n; i >= 1; i--) {
            System.out.println("*".repeat(i));
        }
        System.out.println();
        //  3-фигура
        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n - i) + "*".repeat(i));
        }
        System.out.println();
        //  4-фигура
        for (int i = n; i >= 1; i--) {
            System.out.println(" ".repeat(n - i) + "*".repeat(i));
        }
    }

    /////////////////////////////////////

    public static void swapNumbers(){
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        System.out.println("\nДо обмена:");
        System.out.println("a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("\nПосле обмена:");
        System.out.println("a = " + a + ", b = " + b);
    }

    public static void multiplicationTable(){
        System.out.println("Таблица умножения — выберите режим:");
        System.out.println("1) Полная таблица 1..10");
        System.out.println("2) Таблица для одного числа (1..N)");
        System.out.println("3) Таблица для конкретного числа (a × 1..m)");
        System.out.println("4) Таблицы для диапазона чисел (a..b)");
        System.out.print("Выберите пункт (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                printFullTable(1, 10, 1, 10);
                break;
            case 2:
                System.out.print("Введите N (пока по столбцам 1..N): ");
                int N = scanner.nextInt();
                printFullTable(1, N, 1, N);
                break;
            case 3:
                System.out.print("Введите число a: ");
                int a = scanner.nextInt();
                System.out.print("Введите максимум m (будет a × 1..m): ");
                int m = scanner.nextInt();
                printSingleTable(a, 1, m);
                break;
            case 4:
                System.out.print("Введите начало диапазона a: ");
                int start = scanner.nextInt();
                System.out.print("Введите конец диапазона b: ");
                int end = scanner.nextInt();
                if (start > end) {
                    int tmp = start; start = end; end = tmp;
                }
                printRangeTables(start, end, 1, 10);
                break;
            default:
                System.out.println("Неверный выбор.");
        }

        scanner.close();
    }
    static void printFullTable(int r1, int r2, int c1, int c2) {
        System.out.print("    ");
        for (int c = c1; c <= c2; c++) {
            System.out.printf("%4d", c);
        }
        System.out.println();
        System.out.println("----" + "-".repeat(4 * (c2 - c1 + 1)));

        for (int r = r1; r <= r2; r++) {
            System.out.printf("%3d|", r);
            for (int c = c1; c <= c2; c++) {
                System.out.printf("%4d", r * c);
            }
            System.out.println();
        }
    }
    static void printSingleTable(int a, int from, int to) {
        System.out.println("Таблица умножения для " + a + ":");
        for (int i = from; i <= to; i++) {
            System.out.printf("%d × %d = %d%n", a, i, a * i);
        }
    }
    static void printRangeTables(int start, int end, int from, int to) {
        for (int a = start; a <= end; a++) {
            printSingleTable(a, from, to);
            System.out.println(); // пустая строка между таблицами
        }
    }

    public static void currencyConverter(){
        double exchange = 12145;
        System.out.print("Введите сумму в долларах: ");
        double dollars = scanner.nextDouble();

        double sums = dollars * exchange;
        System.out.println("Сумма в сумах: " + sums);
    }

    public static void evenOrOdd(){
        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("Число " + n + " — чётное.");
        } else {
            System.out.println("Число " + n + " — нечётное.");
        }
    }

    public static void maxOfThree(){
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int c = scanner.nextInt();

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("Наибольшее число: " + max);
    }

    public static void calculator (){
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        double result;

        switch (op) {
            case '+':
                result = a + b;
                System.out.println("Результат: " + result);
                break;
            case '-':
                result = a - b;
                System.out.println("Результат: " + result);
                break;
            case '*':
                result = a * b;
                System.out.println("Результат: " + result);
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                }
                break;
            default:
                System.out.println("Неизвестная операция!");
        }
    }

    public static void averageValue (){
        System.out.print("Введите количество чисел (n): ");
        int n = scanner.nextInt();
        double[] numbers = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Введите число #" + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }

        double average = sum / n;
        System.out.println("Среднее арифметическое: " + average);

    }

    public static void findElement(){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Число " + target + " есть в массиве.");
        } else {
            System.out.println("Числа " + target + " нет в массиве.");
        }
    }

    public static void guessNumberGame(){
        Random random = new Random();

        int secret = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        do {
            System.out.print("Ваш вариант: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > secret) {
                System.out.println("Моё число меньше.");
            } else if (guess < secret) {
                System.out.println("Моё число больше.");
            } else {
                System.out.println("Поздравляю! Вы угадали число " + secret + " за " + attempts + " попыток!");
            }
        } while (guess != secret);
    }

    //////////////////////////////////////////////////

    public static void questGame(){
        String choice;

        System.out.println("🌫️ Ты приходишь в себя на холодном песке у берега озера...");
        System.out.println("Телефон почти разряжен (1%). В кармане — спичка и записка: 'Не доверяй голосам. Иди к северу.'");
        System.out.println("Что делать?");
        System.out.println("1️⃣ Пойти на восток, где виден свет.");
        System.out.println("2️⃣ Пойти на север, как советует записка.");
        System.out.println("3️⃣ Остаться у озера.");
        System.out.print("→ Твой выбор (1/2/3): ");
        choice = scanner.nextLine();

        if (choice.equals("1")) {

            System.out.println("\n💡 Ты идёшь на свет и находишь старую электростанцию...");
            System.out.println("Голос: «Стоять. Идентификация...»");
            System.out.println("1️⃣ Ответить: «Я человек, я потерялся!»");
            System.out.println("2️⃣ Убежать назад в лес.");
            System.out.print("→ Твой выбор: ");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n⚗️ Тебя усыпляют... Очнулся ты уже в лаборатории. Ты стал частью эксперимента.");
                System.out.println("🔚 Концовка: НЕУДАЧА");
            } else {
                System.out.println("\n🌲 Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах...");
                System.out.println("🔚 Концовка: НЕУДАЧА");
            }

        } else if (choice.equals("2")) {

            System.out.println("\n🧭 Ты следуешь на север и находишь заброшенную деревню.");
            System.out.println("В дневнике написано: 'Озеро просыпается в полнолуние. Прячься до рассвета.'");
            System.out.println("1️⃣ Остаться в доме до рассвета.");
            System.out.println("2️⃣ Выйти и идти дальше в туман.");
            System.out.print("→ Твой выбор: ");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n🔥 Ты сидишь у костра. На рассвете приходят выжившие. Ты спасён!");
                System.out.println("🏆 Концовка: ПОБЕДА");
            } else {
                System.out.println("\n📡 Ты находишь маяк и выходишь на связь. На следующий день — эвакуация.");
                System.out.println("🏆 Концовка: ПОБЕДА");
            }

        } else if (choice.equals("3")) {

            System.out.println("\n🌫️ Ты остаёшься у озера. Из тумана слышишь детский голос: «Помоги мне…»");
            System.out.println("1️⃣ Пойти на голос.");
            System.out.println("2️⃣ Убежать прочь в лес.");
            System.out.print("→ Твой выбор: ");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n👧 Ты видишь девочку в белом. Она улыбается и исчезает в воде.");
                System.out.println("🔚 Концовка: ПРОКЛЯТИЕ ОЗЕРА");
            } else {
                System.out.println("\n🌲 Ты бежишь в лес и находишь подземный люк. Внутри — бункер.");
                System.out.println("1️⃣ Разрушить центр управления.");
                System.out.println("2️⃣ Присоединиться к проекту.");
                System.out.print("→ Твой выбор: ");
                choice = scanner.nextLine();

                if (choice.equals("1")) {
                    System.out.println("\n💥 Ты активируешь самоуничтожение. Озеро светится. Мир спасён, но ты погиб.");
                    System.out.println("🦸 Концовка: ГЕРОЙ");
                } else {
                    System.out.println("\n🧠 Ты входишь в проект. Тебе дают новое имя. Теперь ты — часть системы.");
                    System.out.println("🔒 Концовка: ТАЙНЫЙ УЧАСТНИК");
                }
            }
        } else {
            System.out.println("Некорректный ввод. Игра завершена.");
        }

        System.out.println("\n🎭 Спасибо за игру! 'Тень над Озером' — конец истории...");
        scanner.close();
    }


}