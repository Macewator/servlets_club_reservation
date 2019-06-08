package pl.arizona.club.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.arizona.club.model.User;
import pl.arizona.club.util.ConnectionProvider;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlUserDao implements UserDao {

    private static final String CREATE =
            "INSERT INTO user(username,user_firstname,user_lastname,email,password)" +
                    " VALUES(:username,:firstname,:lastname,:email,:password);";
    private static final String READ =
            "SELECT user_id,username,user_firstname,user_lastname,email FROM user WHERE username=:username;";
    private static final String READ_ID =
            "SELECT user_id FROM user WHERE username=:username;";
    private static final String UPDATE_ALL =
            "UPDATE user SET email=:email,password=:password WHERE username=:username;";
    private static final String UPDATE_EMAIL =
            "UPDATE user SET email=:email WHERE username=:username;";
    private static final String UPDATE_PASSWORD =
            "UPDATE user SET password=:password WHERE username=:username;";
    private static final String DELETE =
            "DELETE FROM user WHERE user_id=:userId;";

    private NamedParameterJdbcTemplate template;

    public MySqlUserDao() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public void create(User user) {
        User operationUser = new User(user);
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(operationUser);
        template.update(CREATE, parameterSource);
        setPrivigiles(operationUser);
    }

    private void setPrivigiles(User user) {
        final String role = "INSERT INTO user_role(username) VALUES(:username)";
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", user.getUsername());
        template.update(role, parameterSource);
    }

    @Override
    public User read(User user) {
        User resultUser;
        User operationUser = new User(user);
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", operationUser.getUsername());
        resultUser = template.queryForObject(READ, parameterSource, new UserRowMapper());
        return resultUser;
    }

    @Override
    public void updateAll(User user) {
        User operationUser = new User(user);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", operationUser.getEmail());
        paramMap.put("password", operationUser.getPassword());
        paramMap.put("username", operationUser.getUsername());
        template.update(UPDATE_ALL, paramMap);
    }

    @Override
    public void updateEmail(User user) {
        User operationUser = new User(user);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", operationUser.getEmail());
        paramMap.put("username", operationUser.getUsername());
        template.update(UPDATE_EMAIL, paramMap);
    }

    @Override
    public void updatePassword(User user) {
        User operationUser = new User(user);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("password", operationUser.getPassword());
        paramMap.put("username", operationUser.getUsername());
        template.update(UPDATE_PASSWORD, paramMap);
    }

    @Override
    public void delete(User user) {
        User operationUser = new User(user);
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", operationUser.getUsername());
        int userId = template.query(READ_ID, parameterSource, ResultSet::getType);
        SqlParameterSource parameterSource1 = new MapSqlParameterSource("userId", userId);
        template.update(DELETE, parameterSource1);
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User resultUser = new User();
            resultUser.setId(resultSet.getLong("user_id"));
            resultUser.setUsername(resultSet.getString("username"));
            resultUser.setFirstname(resultSet.getString("user_firstname"));
            resultUser.setLastname(resultSet.getString("user_lastname"));
            resultUser.setEmail(resultSet.getString("email"));
            return resultUser;
        }
    }
}
