package Lesson6;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AirbusA319Console {
    private static final String DATA_FILE = "bookings.txt";
    private static final Map<String, Seat> seats = new LinkedHashMap<>();

    public static void main(String[] args) {
        loadSeats();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== СИСТЕМА БРОНИРОВАНИЯ AIRBUS A319 =====");
            System.out.println("1. Показать схему мест");
            System.out.println("2. Забронировать место");
            System.out.println("3. Отменить бронь");
            System.out.println("4. Информация о месте");
            System.out.println("5. Выход (с сохранением)");
            System.out.print("Ваш выбор: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    printSeats();
                    break;
                case "2":
                    bookSeat(sc);
                    break;
                case "3":
                    cancelSeat(sc);
                    break;
                case "4":
                    seatInfo(sc);
                    break;
                case "5":
                    saveSeats();
                    System.out.println("✅ Данные сохранены. Программа завершена.");
                    return;
                default:
                    System.out.println("❌ Неверный выбор.");
            }
        }
    }


    private static void loadSeats() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Map<String, Seat> loaded = (Map<String, Seat>) ois.readObject();
                seats.putAll(loaded);
                System.out.println("✅ Данные успешно загружены из файла.");
                return;
            } catch (Exception e) {
                System.out.println("⚠️ Ошибка при чтении файла: " + e.getMessage());
            }
        }

        for (int row = 1; row <= 21; row++) {
            String seatClass = (row <= 5) ? "Business" : "Economy";
            boolean limited = (row == 7 || row == 21);
            char lastLetter = (row <= 5) ? 'D' : 'F';
            for (char c = 'A'; c <= lastLetter; c++) {
                String id = row + String.valueOf(c);
                seats.put(id, new Seat(id, seatClass, limited));
            }
        }
        System.out.println("✈️ Создан новый самолет (все места свободны).");
    }

    private static void saveSeats() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(seats);
        } catch (IOException e) {
            System.out.println("⚠️ Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void printSeats() {
        System.out.println("\nСхема самолета:");
        System.out.println("-----------------------------------------------------");
        for (int row = 1; row <= 21; row++) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();

            boolean isBusiness = row <= 5;
            char lastLetter = isBusiness ? 'D' : 'F';

            for (char c = 'A'; c <= lastLetter; c++) {
                Seat seat = seats.get(row + String.valueOf(c));
                String symbol = seat.booked ? "X" : "O"; // X = занято, O = свободно
                if (isBusiness) {
                    if (c <= 'B') left.append(symbol).append(" ");
                    else right.append(symbol).append(" ");
                } else {
                    if (c <= 'C') left.append(symbol).append(" ");
                    else right.append(symbol).append(" ");
                }
            }

            System.out.printf("Ряд %2d | %-6s | %-6s%n", row, left, right);

            if (row == 1) System.out.println("   [WC]");
            if (row == 21) System.out.println("                           [WC]  [WC]");
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("O = свободно | X = занято | WC = туалет");
    }

    private static void bookSeat(Scanner sc) {
        System.out.print("Введите номер места (например, 7A): ");
        String id = sc.nextLine().trim().toUpperCase();
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Такого места нет.");
            return;
        }
        if (seat.booked) {
            System.out.println("❌ Это место уже забронировано.");
            return;
        }

        System.out.print("Введите имя пассажира: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("❌ Имя не введено.");
            return;
        }

        seat.booked = true;
        seat.passengerName = name;
        saveSeats();
        System.out.println("✅ Место " + id + " успешно забронировано (" + name + ").");
    }

    private static void cancelSeat(Scanner sc) {
        System.out.print("Введите номер места для отмены (например, 7A): ");
        String id = sc.nextLine().trim().toUpperCase();
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Такого места нет.");
            return;
        }
        if (!seat.booked) {
            System.out.println("ℹ️ Это место уже свободно.");
            return;
        }

        seat.booked = false;
        seat.passengerName = "";
        saveSeats();
        System.out.println("✅ Бронь на место " + id + " успешно отменена.");
    }

    private static void seatInfo(Scanner sc) {
        System.out.print("Введите номер места (например, 7A): ");
        String id = sc.nextLine().trim().toUpperCase();
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Место не найдено.");
            return;
        }

        System.out.println("\nИнформация о месте:");
        System.out.println("-------------------------");
        System.out.println("Место: " + seat.seatId);
        System.out.println("Класс: " + seat.seatClass);
        System.out.println("Ограниченное отклонение спинки: " + (seat.limitedRecline ? "Да" : "Нет"));
        System.out.println("Статус: " + (seat.booked ? "Занято" : "Свободно"));
        if (seat.booked) System.out.println("Пассажир: " + seat.passengerName);
        System.out.println("-------------------------");
    }
}