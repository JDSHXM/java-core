package Lesson7;

import java.io.*;
import java.util.Scanner;

public class AirbusA319Console {
    private static final String DATA_FILE = "flight_data.txt";
    private static Flight flight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите дату рейса (yyyy-MM-dd): ");
        String date = sc.nextLine().trim();
        loadFlight(date);

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
                case "1" -> flight.printSeats();
                case "2" -> {
                    System.out.print("Введите номер места: ");
                    String id = sc.nextLine().trim().toUpperCase();
                    System.out.print("Введите имя пассажира: ");
                    String name = sc.nextLine().trim();
                    flight.bookSeat(id, name);
                    saveFlight();
                }
                case "3" -> {
                    System.out.print("Введите номер места для отмены: ");
                    String id = sc.nextLine().trim().toUpperCase();
                    flight.cancelSeat(id);
                    saveFlight();
                }
                case "4" -> {
                    System.out.print("Введите номер места: ");
                    String id = sc.nextLine().trim().toUpperCase();
                    flight.seatInfo(id);
                }
                case "5" -> {
                    saveFlight();
                    System.out.println("✅ Данные сохранены. Программа завершена.");
                    return;
                }
                default -> System.out.println("❌ Неверный выбор.");
            }
        }
    }

    private static void loadFlight(String date) {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                flight = (Flight) ois.readObject();
                System.out.println("✅ Данные рейса загружены.");
                return;
            } catch (Exception e) {
                System.out.println("⚠️ Ошибка при загрузке: " + e.getMessage());
            }
        }
        flight = new Flight(date);
        System.out.println("✈️ Новый рейс создан. Все места свободны.");
    }

    private static void saveFlight() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(flight);
        } catch (IOException e) {
            System.out.println("⚠️ Ошибка при сохранении: " + e.getMessage());
        }
    }
}
