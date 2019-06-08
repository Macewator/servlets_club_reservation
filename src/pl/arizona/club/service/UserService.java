package pl.arizona.club.service;

import pl.arizona.club.dao.DAOFactory;
import pl.arizona.club.dao.UserDao;
import pl.arizona.club.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    public void registerUser(String username, String firstname, String lastname, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        String md5Pass = encryptPassword(password);
        user.setPassword(md5Pass);
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        UserDao dao = factory.getUserDAO();
        dao.create(user);
    }

    private String encryptPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());
        String md5Password = new BigInteger(1, digest.digest()).toString(16);
        return md5Password;
    }

    public User createUsersSession(String username){
        User user = new User();
        user.setUsername(username);
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        UserDao dao = factory.getUserDAO();
        User sessionUser = dao.read(user);
        return sessionUser;
    }

    public void updateUserData(User sessionUser, String newEmail, String newPassword){
        DAOFactory factory = DAOFactory.getDAOFactory(1);
        UserDao dao = factory.getUserDAO();

        User updateUser = new User();
        updateUser.setUsername(sessionUser.getUsername());

        if(newEmail != null && newPassword != null){
            updateUser.setEmail(newEmail);
            updateUser.setPassword(newPassword);
            dao.updateAll(updateUser);
        }else if(newEmail != null){
            updateUser.setEmail(newEmail);
            dao.updateEmail(updateUser);
        }else if(newPassword != null){
            updateUser.setPassword(newPassword);
            dao.updatePassword(updateUser);
        }
    }
}
