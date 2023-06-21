package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;



public class Main extends Application implements EventHandler<ActionEvent> {
	Button btn1, btn2, btn3;
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		try {
			window.setTitle("Word Parser");
			
			//Button 1
			btn1 = new Button();
			btn1.setText("top 20");
			btn1.setOnAction(this);
			btn1.setLayoutX(10);
			btn1.setLayoutY(20);
			
			//Button 2
			btn2 = new Button();
			btn2.setText("does word exist");
			btn2.setOnAction(this);
			btn2.setLayoutX(10);
			btn2.setLayoutY(50);
			
			//Button 3
			btn3 = new Button();
			btn3.setText("full poem");
			btn3.setOnAction(this);
			btn3.setLayoutX(10);
			btn3.setLayoutY(80);
			
			//Pane
			Pane p = new Pane();
			p.getChildren().add(btn1);
			
			p.getChildren().add(btn2);
			p.getChildren().add(btn3);
			//sp.getChildren().add(button2);
			//sp.getChildren().add(button3);
			
			Scene scene1;
			scene1 = new Scene(p, 300, 250);
			//scene2 = new Scene(p, 300, 250);
			
			window.setScene(scene1);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handle(ActionEvent event) {
		if(event.getSource()==btn1) {
			System.out.println("top 20 words");
			WordParser wp = new WordParser();
			try {
				wp.wordParser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(event.getSource()==btn2) {
			System.out.println("does word exist");
		}
		if(event.getSource()==btn3) {
			System.out.println("full poem");
		}
	}
}

//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
