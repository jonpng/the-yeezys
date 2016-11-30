package app.controller;

import app.fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import app.model.PersistenceManager;
import app.model.User;

/**
 * Created by Steve on 10/2/2016.
 */
public class RegistrationScreenController {
    private MainFXApplication screen;

    @FXML
    private TextField nameReg;

    @FXML
    private TextField passReg;

    @FXML
    private TextField userReg;

    @FXML
    private Label regError;

    @FXML
    private ComboBox acctType;

    /**
     * Sets the application using this controller.
     * @param screen application using the controller
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    /**
     * Action taken when Register button clicked.
     */
    private void handleRegister() {


        String username = userReg.getCharacters().toString();
        String name = nameReg.getCharacters().toString();
        String password = passReg.getCharacters().toString();
        String account = (String)acctType.getValue();

        if (username.equals("") || password.equals("") || name.equals("") || account == null) {
            regError.setText("Invalid Entry");
            regError.setVisible(true);
            return;
        }

        try {
            PersistenceManager.insertUser(username, password.hashCode(), name, account, screen.getConnection());
        } catch (IllegalArgumentException e) {
            regError.setText("Username Unavailable");
            regError.setVisible(true);

            return;
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }

        screen.init(0);
    }

    @FXML
    /**
     * Action taken when cancel button clicked.
     */
    private void handleCancel() {
        screen.init(0);
    }

    @FXML
    /**
     * Action taken when program closes.
     */
    private void handleClose() {
        System.exit(0);
    }
}
