package Lesson7;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Flight implements Serializable {
    String flightDate; // Дата вылета
    Map<String, Seat> seats = new LinkedHashMap<>();

    public Flight(String flightDate) {
        this.flightDate = flightDate;
        initSeats();
    }

    private void initSeats() {
        for (int row = 1; row <= 21; row++) {
            String seatClass = (row <= 5) ? "Business" : "Economy";
            boolean limited = (row == 7 || row == 21);
            char lastLetter = (row <= 5) ? 'D' : 'F';
            for (char c = 'A'; c <= lastLetter; c++) {
                String id = row + String.valueOf(c);
                seats.put(id, new Seat(id, seatClass, limited));
            }
        }
    }

    public void printSeats() {
        System.out.println("\nСхема самолета (O=Свободно, R=Забронировано, X=Оплачено):");
        System.out.println("-----------------------------------------------------");
        for (int row = 1; row <= 21; row++) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();

            boolean isBusiness = row <= 5;
            char lastLetter = isBusiness ? 'D' : 'F';

            for (char c = 'A'; c <= lastLetter; c++) {
                Seat seat = seats.get(row + String.valueOf(c));
                seat.checkReservationTimeout();
                String symbol;
                switch (seat.status) {
                    case FREE -> symbol = "O";
                    case RESERVED -> symbol = "R";
                    case PAID -> symbol = "X";
                    default -> symbol = "?";
                }

                if (isBusiness) {
                    if (c <= 'B') left.append(symbol).append(" ");
                    else right.append(symbol).append(" ");
                } else {
                    if (c <= 'C') left.append(symbol).append(" ");
                    else right.append(symbol).append(" ");
                }
            }
            System.out.printf("Ряд %2d | %-6s | %-6s%n", row, left, right);
        }
        System.out.println("-----------------------------------------------------");
    }

    public void bookSeat(String id, String name) {
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Место не найдено.");
            return;
        }
        seat.checkReservationTimeout();
        if (seat.status != SeatStatus.FREE) {
            System.out.println("❌ Место занято.");
            return;
        }
        seat.status = SeatStatus.RESERVED;
        seat.passengerName = name;
        seat.bookingTime = LocalDateTime.now();
        System.out.println("✅ Место " + id + " забронировано на 24 минуты (" + name + ").");
    }

    public void cancelSeat(String id) {
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Место не найдено.");
            return;
        }
        seat.status = SeatStatus.FREE;
        seat.passengerName = "";
        seat.bookingTime = null;
        System.out.println("✅ Бронь отменена.");
    }

    public void seatInfo(String id) {
        Seat seat = seats.get(id);
        if (seat == null) {
            System.out.println("❌ Место не найдено.");
            return;
        }
        seat.checkReservationTimeout();
        System.out.println("\nИнформация о месте:");
        System.out.println("-------------------------");
        System.out.println("Место: " + seat.seatId);
        System.out.println("Класс: " + seat.seatClass);
        System.out.println("Статус: " + seat.status);
        if (seat.status == SeatStatus.RESERVED || seat.status == SeatStatus.PAID) {
            System.out.println("Пассажир: " + seat.passengerName);
            System.out.println("Время бронирования: " + seat.bookingTime);
        }
        System.out.println("-------------------------");
    }
}