package controller; /**
 * Created by Brandon on 9/22/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

    private MainFXApplication screen;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label incorrect;

    @FXML
    private Button cancel;

    public boolean pressed = false;

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
        if (screen.login(username, password)) {
            screen.init(1);
        } else {
            incorrect.setVisible(true);
        }
    }

    @FXML
    private void handleLogout() {
        screen.init(0);
    }

    @FXML
    private void handleSignUp() {
        screen.init(2);
    }
}
