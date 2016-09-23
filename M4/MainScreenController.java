/**
 * Created by Brandon on 9/22/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Button;

public class MainScreenController {

    private Login screen;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private DialogPane incorrect;

    @FXML
    private DialogPane loggingIn;

    @FXML
    private Button cancel;

    public boolean pressed = false;

    public void setMain(Login screen) {
        this.screen = screen;
    }

    @FXML
    private void handleClose() {
        System.exit(0);
    }

    @FXML
    private void handleLogin() {
        if (userField.getCharacters().toString().equals("user") && passField.getCharacters().toString().equals("pass")) {
            loggingIn.setVisible(true);
            cancel.setVisible(true);
            screen.init(1);
        } else {
            incorrect.setVisible(true);
        }
    }

    @FXML
    private boolean handleLogout() {
        screen.init(0);
        return true;
    }
}
