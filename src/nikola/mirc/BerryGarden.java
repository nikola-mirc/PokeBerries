package nikola.mirc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BerryGarden extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("layout.fxml"));
		StackPane rooty = new StackPane(root);
		rooty.setId("pane");
		Scene scene = new Scene(rooty);
		BackgroundImage myBI = new BackgroundImage(new Image("background.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		rooty.setBackground(new Background(myBI));
		rooty.setStyle("-fx-background-image: url(" + "\"background.jpg\"" + "); " + "-fx-background-size: cover;");
		stage.setScene(scene);
		stage.getIcons().add(new Image("/icon.png"));
		stage.setTitle("Berry Garden");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
