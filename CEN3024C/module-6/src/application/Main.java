package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;



public class Main extends Application implements EventHandler<ActionEvent> {
	
	Button button;
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		try {
			window.setTitle("Word Parser");
			button = new Button();
			button.setText("top 20");
			
			button.setOnAction(this);
			
			StackPane sp = new StackPane();
			sp.getChildren().add(button);
			
			Scene scene1, scene2, scene3;
			scene1 = new Scene(sp, 300, 250);
			
			window.setScene(scene1);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handle(ActionEvent event) {
		if(event.getSource()==button) {
															//FIXME
		}
	}
}

//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
