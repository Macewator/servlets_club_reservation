package pl.arizona.club.dao;

public abstract class DAOFactory {

    private static final int MYSQL_DB = 1;

    private static DAOFactory factory;

    public abstract MySqlUserDao getUserDAO();
    public abstract MySqlReservationDao getReservationDAO();

    public static DAOFactory getDAOFactory(int dbType){
        if(factory == null){
            if (dbType == MYSQL_DB){
                factory = new MySqlDAOFactory();
            }else {
                throw new IllegalArgumentException();
            }
        }
        return factory;
    }
}
