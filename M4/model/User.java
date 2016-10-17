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

    /**
     * Constructor for a User
     * @param name Name of user
     * @param username username of user
     * @param password password of user
     * @param AccountType AccountType of user
     */
    public User(String name, String username, String password, String AccountType) {
        this.name = name;
        this.username = username;
        this.password = password;
        email = "";
        address = "";
        accountType = AccountType;
    }

    /**
     * Sets username to a new value
     * @param username new value for username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets Username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets email to a new email
     * @param email new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the email address for this user.
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets address for the user
     * @param address new address for the user
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the user's address
     * @return user's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the name of the user
     * @return User's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name new user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's account type
     * @return user's account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Verifies user account
     * @param username entered username
     * @param password entered password
     * @return whether this username matches the entered credentials.
     */
    public boolean verify(String username, String password) {
        return (this.username.equals(username) && this.password.equals(password));
    }
}
