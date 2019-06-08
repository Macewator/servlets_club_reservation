package pl.arizona.club.dao;

import pl.arizona.club.model.User;

public interface UserDao extends GenericDao<User,User>{

    void updateEmail(User user);
    void updatePassword(User user);
}
