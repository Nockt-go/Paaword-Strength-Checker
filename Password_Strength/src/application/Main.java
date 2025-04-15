package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage stage) throws IOException {
		stg = stage;
		stage.setResizable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Password Strength Chacker");
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
