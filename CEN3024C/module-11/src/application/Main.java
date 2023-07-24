package application;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.InputStream;

import java.util.Scanner;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	Scene scene1, scene2, scene3;
	Stage window;
	Button btn1;
	Label title, prompt;
	TextField textField;

	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage window) throws Exception {
		try {
			window.setTitle("Prime Number Calc");
			
			title = new Label("This program determines \nif a number is prime.");
			title.setLayoutX(10);
			title.setLayoutY(10);
			
			prompt = new Label("Enter a number.\n-1 to quit the program.");
			prompt.setLayoutX(10);
			prompt.setLayoutY(50);
			
			btn1 = new Button();
			btn1.setText("Enter");
			btn1.setLayoutX(180);
			btn1.setLayoutY(100);
			
			textField = new TextField();
			textField.setLayoutX(10);
			textField.setLayoutY(100);
			
			Pane p = new Pane();
			p.getChildren().add(title);
			p.getChildren().add(prompt);
			p.getChildren().add(btn1);
			p.getChildren().add(textField);


			
			scene1 = new Scene(p, 250, 200);
			
			window.setScene(scene1);
			window.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource()==btn1) {
			
		}
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		boolean isClose = false;
		Scanner scan = new Scanner(System.in);
		int num = 0;
		System.out.println("Enter -1 to close the program");
		
		do {
			num = scan.nextInt();
			System.out.println("User Entered " + num);
			if (num == -1) {
				isClose = true;
			}
			else {
				Prime.checkPrime(num);
			}
		}
		while(!isClose);
		
		scan.close();
		*/
	
}
