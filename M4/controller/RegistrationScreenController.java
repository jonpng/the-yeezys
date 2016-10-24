package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.PersistenceManager;
import model.User;

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
        User user;

        if (username.equals("") || password.equals("") || name.equals("") || account == null) {
            regError.setText("Invalid Entry");
            regError.setVisible(true);
            return;
        }

        /*ArrayList<User> users = screen.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                regError.setText("Username Unavailable");
                regError.setVisible(true);
                return;
            }
        }

        User user = new User(name, username, password.hashCode(), account);*/

        try {
            PersistenceManager.insertUser(username, password.hashCode(), name, account);
        } catch (IllegalArgumentException e) {
            regError.setText("Username Unavailable");
            regError.setVisible(true);

            return;
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }

        //screen.addUser(user);
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
