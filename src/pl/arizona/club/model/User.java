package pl.arizona.club.model;

public class User {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public User() {
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.firstname = user.firstname;
        this.lastname = user.lastname;
        this.email = user.email;
        this.password = user.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Imię: " + firstname + ", Nazwisko: " + lastname + ", Email: " + email;
    }
}
