package fxapp;

import controller.EditProfileScreenController;
import controller.LoginScreenController;
import controller.MainScreenController;
import controller.RegistrationScreenController;
import controller.ReportListController;
import controller.AddReportScreenController;
import controller.ReportController;
import controller.WaterAvailabilityScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;
import model.Report;
import model.ReportList;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableListBase;

public class MainFXApplication extends Application {

	private static final Logger LOGGER = Logger.getLogger("fxapp.MainFXApplication");
	private Stage stage;
	private Pane layout;
	private ArrayList<User> users = new ArrayList<User>();
	private ReportList<Report> reports = new ReportList<Report>();
	private LoginScreenController loginControl;
	private MainScreenController mainControl;
	private RegistrationScreenController regControl;
	private EditProfileScreenController editControl;
	private ReportListController reportControl;
	private AddReportScreenController addReportControl;
	private ReportController repControl;
	private WaterAvailabilityScreenController mapControl;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		initLayout(this.stage);
	}

	/**
	 * Initializes and loads the login screen.
	 * @param stage Stage that screen is loaded into.
	 */
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

	/**
	 * Initializes and loads the Main App Screen,
	 * @param stage loaded for user to interact with.
	 */
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

	/**
	 * Initializes and loads the registration screen.
	 * @param stage loaded for user to interact with
	 */
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

	/**
	 * Initializes and loads the edit profile screen.
	 * @param stage loaded for user to interact with.
	 */
	private void initEdit(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/EditProfileScreen.fxml"));
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

    /**
     * Initializes and loads report list.
     * @param stage loaded for user to interact with.
     */
	private void initReportList(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/ReportListScreen.fxml"));
			layout = loader.load();

			reportControl = loader.getController();
			reportControl.setMain(this);

			reportControl.loadReports();
			reportControl.loadUser(loginControl.getUser());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

    /**
     * Initializes and loads the add report screen.
     * @param stage loaded for user to interact with.
     */
	private void initAdd(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/AddReportScreen.fxml"));
			layout = loader.load();

			addReportControl = loader.getController();
			addReportControl.setMain(this);

			addReportControl.loadUser(loginControl.getUser());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

    /**
     * Initializes and loads an individual report.
     * @param stage loaded for user to interact with.
     */
	private void initRep(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/ReportScreen.fxml"));
			layout = loader.load();

			repControl = loader.getController();
			repControl.setMain(this);

			repControl.loadReport(reportControl.getSelection());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	/**
	 * Initializes and loads map
	 * @param stage loaded for user to interact with
	 */
	private void initMap(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("../view/WaterAvailabilityScreen.fxml"));
			layout = loader.load();

			mapControl = loader.getController();
			mapControl.setMain(this);

			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	/**
	 * Handles exceptions
	 * @param e An exception to be handled.
	 */
	private void handle(Exception e) {
		LOGGER.log(Level.SEVERE, "Error occurred");
		e.printStackTrace();
		System.exit(0);
	}
    /**
     * Initializes and loads a specific screen.
     * @param select Integer value used to select which screen to load.
     */
	public void init(int select) {
		if (select == 0) {
			initLayout(stage);
		} else if (select == 1) {
			initApp(stage);
		} else if (select == 2) {
			initReg(stage);
		} else if (select == 3) {
			initEdit(stage);
		} else if (select == 4) {
			initReportList(stage);
		} else if (select == 5) {
			initAdd(stage);
		} else if (select == 6) {
			initRep(stage);
		} else if (select == 7) {
			initMap(stage);
		}
	}

    /**
     * Adds a User to the system.
     * @param user User added to the system.
     */
	public void addUser(User user) {
		users.add(user);
    }

    /**
     * Gets a list of Users registered in the system.
     * @return list of Users
     */
	public ArrayList<User> getUsers() {
		return users;
	}

    /**
     * Adds a report to the app
     * @param r report added to the application.
     */
	public void addReport(Report r) {
		reports.add(r);
	}

    /**
     * Gets a list of Reports listed in the system.
     * @return list of Reports
     */
	public ReportList<Report> getReports() {
		return reports;
	}

    /**
     * Checks entered credentials, and logs user in if applicable.
     * @param username username entered by the user.
     * @param password password entered by the user.
     * @return User whose username and password matches the params.
     */
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