package pl.arizona.club.service;

import pl.arizona.club.dao.DAOFactory;
import pl.arizona.club.dao.ReservationDao;
import pl.arizona.club.model.Reservation;
import pl.arizona.club.model.User;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReservationService {

    public void addReservation(String date, String reservationType, User user) {
        try {
            Reservation reservation = new Reservation();
            SimpleDateFormat datetimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date fromDate = datetimeFormatter.parse(date);
            Timestamp timestamp = new Timestamp(fromDate.getTime());
            reservation.setDate(timestamp);
            reservation.setReservationType(reservationType);
            User userCopy = new User(user);
            reservation.setUser(userCopy);
            DAOFactory factory = DAOFactory.getDAOFactory(1);
            ReservationDao reservationDao = factory.getReservationDAO();
            reservationDao.create(reservation);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getAllUserReservation(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        ReservationDao reservationDao = factory.getReservationDAO();
        List<Reservation> reservations = reservationDao.readAllUserReservations(userId);
        return reservations;
    }

    public void deleteReservation(String reservID){
        Long deleteID = Long.valueOf(reservID);
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        ReservationDao reservationDao = factory.getReservationDAO();
        reservationDao.delete(deleteID);
    }
}
