package pl.arizona.club.dao;

public class MySqlDAOFactory extends DAOFactory{

    @Override
    public MySqlUserDao getUserDAO() {
        return new MySqlUserDao();
    }

    @Override
    public MySqlReservationDao getReservationDAO() {
        return new MySqlReservationDao();
    }
}
