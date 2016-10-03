package fxapp;

import controller.LoginScreenController;
import controller.RegistrationScreenController;
import controller.MainScreenController;
import controller.EditScreenController;
import model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class MainFXApplication extends Application {

	private static final Logger LOGGER = Logger.getLogger("fxapp.MainFXApplication");
	private Stage stage;
	private Pane layout;
	private ArrayList<User> users = new ArrayList<User>();
	private LoginScreenController loginControl;
	private MainScreenController mainControl;
	private RegistrationScreenController regControl;
	private EditScreenController editControl;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		initLayout(this.stage);
	}

	private void initLayout(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("../view/LoginScreen.fxml"));
			layout = loader.load();

			LoginScreenController control;
			loginControl = loader.getController();
			loginControl.setMain(this);
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void initApp(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/MainScreen.fxml"));
			layout = loader.load();

			MainScreenController control;
			mainControl = loader.getController();
			mainControl.setMain(this);
			mainControl.loadUser(loginControl.getUser());
			mainControl.loadProfile();
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void initReg(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/RegistrationScreen.fxml"));
			layout = loader.load();

			RegistrationScreenController control;
			regControl = loader.getController();
			regControl.setMain(this);
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void initEdit(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/EditScreen.fxml"));
			layout = loader.load();

			editControl = loader.getController();
			editControl.setMain(this);
			editControl.loadUser(mainControl.getUser());
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void init(int select) {
		if (select == 0) {
			initLayout(stage);
		} else if (select == 1) {
			initApp(stage);
		} else if (select == 2) {
			initReg(stage);
		} else {
			initEdit(stage);
		}
	}

	public void addUser(User user) {
		users.add(user);
}

	public ArrayList<User> getUsers() {
		return users;
	}

	public User login(String username, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).verify(username, password)) {
				return users.get(i);
			}
		}
		return null;
	}

	public static void main(String[]args) {
		launch(args);
	}
}