package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public long duration() {
        long diff = ChronoUnit.DAYS.between(checkin, checkout);
        return diff;
    }

    public String updateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();
        if (checkin.isBefore(now) || checkout.isBefore(now)) {
            return "Error in reservation: Check-out date must be future dates";
        }
        if (!checkout.isBefore(checkin)) {
            return "Error in reservation: Check-out date must be after check-in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null; // como o método precisa retornar uma str, caso não haja nenhum erro nas verificações, o programa retornar null
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room ")
        .append(roomNumber)
        .append(", check-in :")
        .append(checkin.format(fmt))
        .append(", check-out: ")
        .append(checkout.format(fmt))
        .append(", ")
        .append(duration())
        .append(" nights");
        return sb.toString();
    }
}
