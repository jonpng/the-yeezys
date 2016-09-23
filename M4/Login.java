import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.TimerTask;

public class Login extends Application {

	private static final Logger LOGGER = Logger.getLogger("Login");
	private Stage stage;
	private Pane layout;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		initLayout(this.stage);
	}

	private void initLayout(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("MainScreen.fxml"));
			layout = loader.load();

			MainScreenController control = new MainScreenController();
			control = loader.getController();
			control.setMain(this);
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
			loader.setLocation(this.getClass().getResource("App.fxml"));
			layout = loader.load();

			MainScreenController control = new MainScreenController();
			control = loader.getController();
			control.setMain(this);
			stage.setTitle("Water Conservation Report.");
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
		} else {
			initApp(stage);
		}
	}

	public static void main(String[]args) {
		launch(args);
	}
}