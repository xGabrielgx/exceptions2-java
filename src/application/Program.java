package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt1);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt1);

        // se data de check out não é depois que a data de check-in
        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), fmt1);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), fmt1);

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null ) {
                System.out.println("Erorr in reservation: " + error);
            } else {
                System.out.println("Reservation: " + reservation);
            }
        }








        sc.close();


        // forma de colocar o colocar para consegui pegar os segundos para calcular o duration tem que colocar sempre o
        // o Padrão as horas e minutos.
//        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//
//        LocalDateTime checkIn = LocalDateTime.parse("23/09/2019 00:00", fmt1);
//        LocalDateTime checkOut = LocalDateTime.parse("26/09/2019 00:00", fmt1);
//        Reservation r1 = new Reservation(8021, checkIn, checkOut);
//        System.out.println(r1);

    }
}
