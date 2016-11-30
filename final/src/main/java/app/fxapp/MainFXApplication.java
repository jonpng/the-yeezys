package app.fxapp;

import app.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import app.model.PurityReport;
import app.model.Report;
import app.model.ReportList;
import app.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFXApplication extends Application {

	private static final Logger LOGGER = Logger.getLogger("app.fxapp.MainFXApplication");
	private Stage stage;
	private Pane layout;
	private boolean reportLoaded = false;
	private boolean purityLoaded = false;
	private ArrayList<User> users = new ArrayList<User>();
	private ReportList<Report> reports = new ReportList<Report>();
	private ReportList<PurityReport> purityReports = new ReportList<PurityReport>();
	private LoginScreenController loginControl;
	private MainScreenController mainControl;
	private RegistrationScreenController regControl;
	private EditProfileScreenController editControl;
	private ReportListScreenController reportListControl;
    private PurityReportListScreenController purityReportListControl;
	private AddReportScreenController addReportControl;
	private AddPurityReportScreenController addQualityReportControl;
	private ReportScreenController repControl;
	private PurityReportScreenController qualityRepControl;
	private WaterAvailabilityScreenController mapControl;
	private GraphScreenController graphControl;
	private HistoricalReportSelectController historyControl;
	private Report selected;
	private Connection connect;


	@Override
	public void start(Stage stage) throws SQLException {
		this.stage = stage;
		initLayout(this.stage);
		connect = DriverManager.getConnection("jdbc:mysql://clean-water-project.cxabeuavtgvv.us-west-2.rds.amazonaws.com:3306/clean_water_project?", "sqluser", "sqluserpw");
	}

	/**
	 * Initializes and loads the login screen.
	 * @param stage Stage that screen is loaded into.
	 */
	private void initLayout(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/app/view/LoginScreen.fxml"));
			layout = loader.load();

			loginControl = loader.getController();
			loginControl.setMain(this);
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	/**
	 * Initializes and loads the Main App Screen,
	 * @param stage loaded for user to interact with.
	 */
	private void initApp(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/MainScreen.fxml"));
			layout = loader.load();

			mainControl = loader.getController();
			mainControl.setMain(this);
			mainControl.loadUser(loginControl.getUser());
			mainControl.loadProfile();
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	/**
	 * Initializes and loads the registration screen.
	 * @param stage loaded for user to interact with
	 */
	private void initReg(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/RegistrationScreen.fxml"));
			layout = loader.load();

			regControl = loader.getController();
			regControl.setMain(this);
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	/**
	 * Initializes and loads the edit profile screen.
	 * @param stage loaded for user to interact with.
	 */
	private void initEdit(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/EditProfileScreen.fxml"));
			layout = loader.load();

			editControl = loader.getController();
			editControl.setMain(this);
			editControl.loadUser(mainControl.getUser());
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

    /**
     * Initializes and loads report list.
     * @param stage loaded for user to interact with.
     */
	private void initReportList(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/ReportListScreen.fxml"));
			layout = loader.load();

			reportListControl = loader.getController();
			reportListControl.setMain(this);

			reportListControl.loadReports();
			reportListControl.loadUser(loginControl.getUser());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occurred");
			e.printStackTrace();
			System.exit(0);
		}
	}

    private void initPurityReportList(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/app/view/PurityReportListScreen.fxml"));
            layout = loader.load();

            purityReportListControl = loader.getController();
            purityReportListControl.setMain(this);

            purityReportListControl.loadReports();
            purityReportListControl.loadUser(loginControl.getUser());
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
			loader.setLocation(getClass().getResource("/app/view/AddReportScreen.fxml"));
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

	private void initAddPurity(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/AddPurityReportScreen.fxml"));
			layout = loader.load();

			addQualityReportControl = loader.getController();
			addQualityReportControl.setMain(this);

			addQualityReportControl.loadUser(loginControl.getUser());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

    /**
     * Initializes and loads an individual report.
     * @param stage loaded for user to interact with.
     */
	private void initRep(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/ReportScreen.fxml"));
			layout = loader.load();

			repControl = loader.getController();
			repControl.setMain(this);

			repControl.loadReport(reportListControl.getSelection());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			handle(e);
		}
	}

	private void initPurityRep(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/PurityReportScreen.fxml"));
			layout = loader.load();

			qualityRepControl = loader.getController();
			qualityRepControl.setMain(this);

			qualityRepControl.loadReport(purityReportListControl.getSelection());
			stage.setTitle("Water Conservation Report");
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
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
			loader.setLocation(getClass().getResource("/app/view/WaterAvailabilityScreen.fxml"));
			layout = loader.load();

			mapControl = loader.getController();
			mapControl.setMain(this);
			mapControl.loadReports(reports);

			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	private void initPin(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/MapReportScreen.fxml"));
			layout = loader.load();

			MapReportScreenController mapRepControl = loader.getController();
			mapRepControl.setMain(this);
			mapRepControl.loadReport(selected);
			stage.setScene(new Scene(layout));
			stage.show();

		} catch (Exception e) {
			handle(e);
		}
	}

	private void initGraph(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/GraphScreen.fxml"));
			layout = loader.load();

			graphControl = loader.getController();
			graphControl.setMain(this);

			PurityReport pr = historyControl.getPReport();
			graphControl.loadReport(pr);

			graphControl.draw();
			stage.setScene(new Scene(layout));
			stage.show();
		} catch (Exception e) {
			handle(e);
		}
	}

	private void initHistorySel(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("/app/view/HistoricalReportSelectScreen.fxml"));
			layout = loader.load();

			historyControl = loader.getController();
			historyControl.setMain(this);

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
		} else if (select == 8) {
			initPin(stage);
		} else if (select == 9) {
			initAddPurity(stage);
		} else if (select == 10) {
			initPurityRep(stage);
		} else if (select == 11) {
            initPurityReportList(stage);
        } else if (select == 12) {
			initGraph(stage);
		} else if (select == 13) {
			initHistorySel(stage);
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

	public void addQualityReport(PurityReport r) {
		purityReports.add(r);
	}

	public ReportList<PurityReport> getPurityReports() {
		return purityReports;
	}

	public boolean isReportLoaded() {
		return reportLoaded;
	}

	public boolean isPurityLoaded() {
		return purityLoaded;
	}

	public void setReportLoaded() {
		reportLoaded = true;
	}

	public void setPurityLoaded() {
		purityLoaded = true;
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

	public Connection getConnection() {
		return connect;
	}

	public void setSelected(Report report) {
		this.selected = report;
	}

	public static void main(String[]args) {
		System.setProperty("java.net.useSystemProxies", "true");
		launch(args);
	}
}