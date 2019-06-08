package pl.arizona.club.model;

import java.sql.Timestamp;

public class Reservation {

    private Integer reservationId;
    private Timestamp date;
    private String reservationType;
    private User user;

    public Reservation() {
    }

    public Reservation(Reservation reservation) {
        this.reservationId = reservation.reservationId;
        this.date = reservation.date;
        this.reservationType = reservation.reservationType;
        this.user = reservation.user;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ID: " + reservationId + ", typ: " + reservationType + " ";
    }
}
