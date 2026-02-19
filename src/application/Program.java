package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.excpetions.DomainException;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (dd/mm/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out");
            checkout = LocalDate.parse(sc.nextLine(), fmt);

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservetaion: " + reservation);
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}