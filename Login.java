import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.beans.property.StringProperty;

public class Login extends Application {

	public void start(Stage stage) {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.setTitle("Clean Water Conservation Report");
		stage.show();
	}
}