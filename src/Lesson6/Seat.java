package Lesson6;

import java.io.Serializable;

public class Seat implements Serializable {
    String seatId;
    String seatClass;
    boolean limitedRecline;
    boolean booked;
    String passengerName;

    public Seat(String seatId, String seatClass, boolean limitedRecline) {
        this.seatId = seatId;
        this.seatClass = seatClass;
        this.limitedRecline = limitedRecline;
        this.booked = false;
        this.passengerName = "";
    }

    @Override
    public String toString() {
        String status = booked ? "[X]" : "[ ]";
        return String.format("%-3s %-2s (%s)", seatId, status, seatClass);
    }
}
