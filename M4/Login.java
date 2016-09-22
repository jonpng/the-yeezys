import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.logging.Logger;
import java.util.logging.Level;

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
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(this.getClass().getResource("MainScreen.fxml"));
			layout = loader.load();

			MainScreenController control = loader.getController();
			control.setMain(this);
			stage.setTitle("Water Conservation Report");
			Scene scene = new Scene(layout);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "You done goofed.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void main(String[]args) {
		launch(args);
	}
}