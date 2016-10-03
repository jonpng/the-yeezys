package controller; /**
 * Created by Brandon on 9/22/16.
 */

import fxapp.MainFXApplication;
import model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class LoginScreenController {

    private MainFXApplication screen;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label incorrect;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label address;

    private User user;

    private StringProperty nameProperty;

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    private void handleClose() {
        System.exit(0);
    }

    @FXML
    private void handleLogin() {
        String username = userField.getCharacters().toString();
        String password = passField.getCharacters().toString();
        user = screen.login(username, password);
        if (user != null) {
            screen.init(1);
        } else {
            incorrect.setVisible(true);
        }
    }

    @FXML
    private void handleSignUp() {
        screen.init(2);
    }

    @FXML
    public User getUser() {
        return user;
    }
}
