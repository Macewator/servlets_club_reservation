package pl.arizona.club.dao;

import pl.arizona.club.model.Reservation;

import java.util.List;

public interface ReservationDao extends GenericDao<Long,Reservation>{

    List<Reservation> readAllUserReservations(Long l);
}
