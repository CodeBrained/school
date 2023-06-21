package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;



public class Main extends Application {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Word Parser");
			button = new Button();
			button.setText("Click me");
			
			StackPane sp = new StackPane();
			sp.getChildren().add(button);
			
			Scene scene = new Scene(sp, 300, 250);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
