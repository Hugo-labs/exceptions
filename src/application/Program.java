package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        Integer roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Check-out date (dd/mm/yyyy): ");
        LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);

        if (!checkout.isAfter(checkin)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out");
            checkout = LocalDate.parse(sc.nextLine(), fmt);

            String error = reservation.updateDates(checkin, checkout);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservetaion: " + reservation);
            }
        }

        sc.close();
    }
}