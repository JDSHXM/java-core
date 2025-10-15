package Lesson7;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Seat implements Serializable {
    String seatId;
    String seatClass;
    boolean limitedRecline;
    SeatStatus status;
    String passengerName;
    LocalDateTime bookingTime;

    public Seat(String seatId, String seatClass, boolean limitedRecline) {
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.limitedRecline = limitedRecline;
        this.status = SeatStatus.FREE;
        this.passengerName = "";
        this.bookingTime = null;
    }

    // Проверяем, не истекла ли бронь (24 минуты)
    public void checkReservationTimeout() {
        if (status == SeatStatus.RESERVED && bookingTime != null) {
            if (Duration.between(bookingTime, LocalDateTime.now()).toMinutes() > 24) {
                status = SeatStatus.FREE;
                passengerName = "";
                bookingTime = null;
            }
        }
    }

    @Override
    public String toString() {
        checkReservationTimeout();
        String symbol;
        switch (status) {
            case FREE -> symbol = "O";
            case RESERVED -> symbol = "R";
            case PAID -> symbol = "X";
            default -> symbol = "?";
        }
        return String.format("%-3s [%s] (%s)", seatId, symbol, seatClass);
    }
}

