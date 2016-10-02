package model;

import java.util.ArrayList;

/**
 * Created by Brandon on 10/2/16.
 */
public class User {

    private String name;
    private String username;
    private String password;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean verify(String username, String password) {
        return (this.username.equals(username) && this.password.equals(password));
    }
}
