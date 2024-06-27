package model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        // pegando os dias entre as datas de entrada e saida.
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public String updateDates(LocalDate checkIin, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            return "Reservation dates for update must be future dates.";
        }
        // se a data de check não for posterior/depois a data de check-in
        if (!checkOut.isAfter(checkIn)) {
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIin;
        this.checkOut = checkOut;
        // se retorna o nulo é pq não deu nenhum erro.
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in "
                + formatter.format(checkIn)
                + ", check-out "
                + formatter.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
