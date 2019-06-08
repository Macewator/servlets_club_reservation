package pl.arizona.club.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.arizona.club.model.Reservation;
import pl.arizona.club.model.User;
import pl.arizona.club.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlReservationDao implements ReservationDao {

    private static final String CREATE =
            "INSERT INTO reservation(date,reservation_type,user_id) VALUES(:date,:reservation,:userId);";
    private static final String READ =
            "SELECT reservation_id,date,reservation_type FROM reservation WHERE user_id=:userId;";
    private static final String UPDATE =
            "UPDATE reservation SET date=:date,reservation_type=:reservation WHERE reservation_id = :reservId;";
    private static final String DELETE =
            "DELETE FROM reservation WHERE reservation_id=:reservation;";

    private NamedParameterJdbcTemplate template;

    public MySqlReservationDao() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public void create(Reservation reservation) {
        Reservation operationReserv = new Reservation(reservation);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("date", operationReserv.getDate());
        paramMap.put("reservation", operationReserv.getReservationType());
        paramMap.put("userId", operationReserv.getUser().getId());
        template.update(CREATE, paramMap);
    }

    @Override
    public Reservation read(Long userId) {
        return null;
    }

    @Override
    public List<Reservation> readAllUserReservations(Long userId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", userId);
        List<Reservation> reservations = template.query(READ, parameterSource, new ReservationRowMapper());
        return reservations;
    }

    @Override
    public void updateAll(Reservation reservation) {
        Reservation operationReserv = new Reservation(reservation);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("date", operationReserv.getDate());
        paramMap.put("reservation", operationReserv.getReservationType());
        paramMap.put("reservId", operationReserv.getReservationId());
        template.update(UPDATE, paramMap);
    }

    @Override
    public void delete(Long reservID) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("reservation", reservID);
        template.update(DELETE, parameterSource);
    }


    private class ReservationRowMapper implements RowMapper<Reservation> {
        @Override
        public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
            Reservation reserv = new Reservation();
            reserv.setReservationId(resultSet.getInt("reservation_id"));
            reserv.setDate(resultSet.getTimestamp("date"));
            reserv.setReservationType(resultSet.getString("reservation_type"));
            return reserv;
        }
    }
}
