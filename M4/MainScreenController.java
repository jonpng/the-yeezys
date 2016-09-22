/**
 * Created by Brandon on 9/22/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class MainScreenController {

    private Login screen;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

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
            screen.init(1);
        } else {
            System.out.println("Incorrect username or password");
        }
    }

    @FXML
    private void handleLogout() {
        screen.init(0);
    }
}
