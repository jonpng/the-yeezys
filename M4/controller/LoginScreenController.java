package controller; /**
 * Created by Brandon on 9/22/16.
 */

import fxapp.MainFXApplication;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.PersistenceManager;
import model.User;

import java.util.NoSuchElementException;

public class LoginScreenController {

    private MainFXApplication screen;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label incorrect;

    private User user;


    /**
     * Sets app using this controller
     * @param screen App using this controller
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    /**
     * Action taken when user closes the application.
     */
    private void handleClose() {
        System.exit(0);
    }

    @FXML
    /**
     * Action taken when user clicks Login.
     */
    private void handleLogin() {
        String username = userField.getCharacters().toString();
        String password = passField.getCharacters().toString();
        /*user = screen.login(username, password);

        if (user != null) {
            screen.init(1);
        } else {
            incorrect.setVisible(true);
        }*/


        //Persistence code can only be used once the sql server is being hosted online
        try {
            user = PersistenceManager.accessUser(username, password.hashCode(), screen.getConnection());

            if (user != null) {
                screen.init(1);
            } else {
                incorrect.setVisible(true);
            }
        } catch (NoSuchElementException e) {
            incorrect.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    /**
     * Action taken when user clicks Sign-Up
     */
    private void handleSignUp() {
        screen.init(2);
    }

    @FXML
    /**
     * Get the user that logged into the system
     * @return user that logged into the system
     */
    public User getUser() {
        return user;
    }
}
