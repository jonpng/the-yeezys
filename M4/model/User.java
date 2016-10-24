package model;

/**
 * Created by Brandon on 10/2/16.
 */
public class User {

    private String name;
    private String username;
    private int password;
    private String email;
    private String address;
    private String accountType;

    public User(String name, String username, int password, String accountType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = "";
        this.address = "";
        this.accountType = accountType;
    }

    public User(String name, String username, int password, String accountType, String email, String address) {
        this(name, username, password, accountType);
        this.email = email;
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean verify(String username, String password) {
        return (this.username.equals(username) && this.password == password.hashCode());
    }
}
