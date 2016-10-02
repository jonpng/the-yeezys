package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import model.User;
import java.util.ArrayList;

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

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    private void handleRegister() {
        String username = userReg.getCharacters().toString();
        String name = nameReg.getCharacters().toString();
        String password = passReg.getCharacters().toString();
        if (username.equals("") || password.equals("") || name.equals("")) {
            regError.setVisible(true);
            return;
        }
        ArrayList<User> users = screen.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                regError.setVisible(true);
                return;
            }
        }
        User user = new User(name, username, password);
        screen.addUser(user);
        screen.init(0);
    }

    @FXML
    private void handleCancel() {
        screen.init(0);
    }
}
