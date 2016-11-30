package app.controller;

/**
 * Created by Brandon on 10/3/16.
 */

import app.fxapp.MainFXApplication;
import app.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.property.StringProperty;

public class MainScreenController {

    private MainFXApplication screen;
    private User user;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label type;

    private String nameString;
    private String emailString;
    private String addressString;
    private String typeString;

    @FXML
    /**
     * Action taken when Logout is pressed
     */
    private void handleLogout() {
        screen.init(0);
    }

    /**
     * Sets the main application this controller pertains to.
     * @param app application controller is used.
     */
    public void setMain(MainFXApplication app) {
        screen = app;
    }

    /**
     * Loads the user logged into the system
     * @param user user logged into the system
     */
    public void loadUser(User user) {
        this.user = user;
    }

    /**
     * Loads the profile of the user logged into the system.
     */
    public void loadProfile() {
        String name = user.getName();
        String email = user.getEmail();
        if (email == null) {
            email = "N/A";
        }
        String address = user.getAddress();
        if (address == null) {
            address = "N/A";
        }
        String type = user.getAccountType();

        this.name.setText(name);
        this.email.setText("Email: " + email);
        this.address.setText("Address: " + address);
        this.type.setText("Acct. Type: " + type);

        this.name.setVisible(true);
        this.email.setVisible(true);
        this.address.setVisible(true);
        this.type.setVisible(true);
    }

    /**
     * Simulates loadProfile for testing purposes
     */
    public void load() {
        nameString = user.getName();
        emailString = user.getEmail();
        if (user.getEmail() == null) {
            emailString = "N/A";
        }
        addressString = user.getAddress();
        if (user.getAddress() == null) {
            addressString = "N/A";
        }
        typeString = user.getAccountType();
    }

    /**
     * Gets the user logged into the system
     * @return user logged into the system
     */
    public User getUser() {
        return user;
    }

    @FXML
    /**
     * Action taken when Edit button selected.
     */
    private void handleEdit() {
        screen.init(3);
    }

    @FXML
    /**
     * Action taken when program closes.
     */
    private void handleClose() {
        System.exit(0);
    }

    @FXML
    /**
     * Action taken when View Report button clicked.
     */
    private void handleView() {
        screen.init(4);
    }

    /**
     * Returns the name Label
     * @return name Label
     */
    public String getName() {
        return nameString;
    }

    /**
     * Returns the email Label
     * @return email label
     */
    public String getEmail() {
        return emailString;
    }

    /**
     * Returns the address label
     * @return the address label
     */
    public String getAddress() {
        return addressString;
    }

    /**
     * Returns the type label
     * @return the type Label
     */
    public String getType() {
        return typeString;
    }
}
