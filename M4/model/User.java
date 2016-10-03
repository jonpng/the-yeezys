package model;

import java.util.ArrayList;

/**
 * Created by Brandon on 10/2/16.
 */
public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private String accountType;

    public User(String name, String username, String password, String AccountType) {
        this.name = name;
        this.username = username;
        this.password = password;
        email = "";
        address = "";
        accountType = AccountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return (this.username.equals(username) && this.password.equals(password));
    }
}
