package controller;

/**
 * Created by Brandon on 10/3/16.
 */

import fxapp.MainFXApplication;
import model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainScreenController {

    private MainFXApplication screen;
    private User user;
    private StringProperty nameProperty;
    private StringProperty emailProperty;
    private StringProperty addressProperty;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label type;

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
        String address = user.getAddress();
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
}
