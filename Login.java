import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Login extends Application {

	public void start(Stage stage) {
		loginScreen(stage);
		stage.setTitle("Clean Water Conservation Report");
		stage.show();
	}

	private void loginScreen(Stage stage) {
		GridPane grid = new GridPane();
		grid.setMinWidth(300);
		grid.setMinHeight(300);
		grid.setVgap(10);
		grid.setHgap(10);
		//grid.setGridLinesVisible(true);
		grid.setAlignment(Pos.CENTER);
		TextField user = new TextField("Username");
		TextField pass = new TextField("Password");
		Text app = new Text("Clean Water Conservation Report");


		Button login = new Button("Login");
		login.setMinSize(68, 30);

		login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String username = user.getCharacters().toString();
				String password = pass.getCharacters().toString();

				if (username.equals("User") && password.equals("Pass")) {
					loggedIn(stage);
					return;
				} else {

				}
			}
		});
		Button register = new Button("Sign Up");
		register.setMinSize(50,30);
		login.setDefaultButton(true);


		grid.add(app, 0, 0, 14, 3);
		grid.add(user, 0, 4, 10, 3);
		grid.add(pass, 0, 7, 10, 3);
		grid.add(login, 0, 10, 7, 3);
		grid.add(register, 0, 13, 7, 3);
		Scene scene = new Scene(grid);
		stage.setScene(scene);
	}

	private void loggedIn(Stage stage) {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setMinHeight(300);
		grid.setMaxHeight(300);
		Button logout = new Button("Log Out");
		grid.setAlignment(Pos.CENTER);
		grid.add(logout, 0, 0, 10, 3);
		Scene scene = new Scene(grid);
		stage.setScene(scene);
	}

	private void signUp(Stage stage) {

	}
}