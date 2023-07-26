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
import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class Main extends Application implements EventHandler<ActionEvent> {
	Button btn1, btn2, btn3, btnHome1, btnHome2;
	ScrollPane sp;
	Scene scene, scene2, scene3;
	Stage window;
	TextArea top20;
	Label label, title;
	String[] list = new String[20];
	
	public static void main(String[] args) throws Exception {
		launch(args);
		getConnection();
		
	}
	
	@Override
	public void start(Stage window) {
		try {
			window.setTitle("Word Parser");
			
			//Button top 20
			btn1 = new Button();
			btn1.setText("top 20 words");
			btn1.setOnAction(e -> window.setScene(scene2));
			btn1.setLayoutX(140);
			btn1.setLayoutY(120);
			
			//Button "full poem"
			btn2 = new Button();
			btn2.setText("full poem");
			btn2.setOnAction(e -> window.setScene(scene3));
			btn2.setLayoutX(60);
			btn2.setLayoutY(120);
			
			//Button "show top 20"
			btn3 = new Button();
			btn3.setText("generate top 20 words");
			btn3.setOnAction(this);
			btn3.setLayoutX(140);
			btn3.setLayoutY(200);

			
			//Button "Home"
			btnHome1 = new Button();
			btnHome1.setText("Home");
			btnHome1.setOnAction(e -> window.setScene(scene));
			btnHome1.setLayoutX(180);
			btnHome1.setLayoutY(240);
			
			//Button "Home"
			//Button "Home"
			btnHome2 = new Button();
			btnHome2.setText("Home");
			btnHome2.setOnAction(e -> window.setScene(scene));
			btnHome2.setLayoutX(180);
			btnHome2.setLayoutY(240);
			
			//ScrollPane
			sp = new ScrollPane();
			WordParser fullPoem = new WordParser();
			Text text = new Text(fullPoem.getText());
			Rectangle rect = new Rectangle(500, 450);
			sp.setPrefSize(400, 40);
			sp.setContent(rect);
			sp.setContent(text);
			
			//Title label
			title = new Label("The Raven\nBy Edgar Allen Poe");
			title.setLayoutX(10);
			title.setLayoutY(10);
			
			//Information label
			label = new Label("The following buttons will direct you to both the\nfull poem and the top 20 words listed in the poem");
			label.setLayoutX(10);
			label.setLayoutY(60);
			label.wrapTextProperty();
			
			//TextArea
			top20 = new TextArea();
			
			//Layout home
			Pane p = new Pane();
			p.getChildren().add(btn1);
			p.getChildren().add(btn2);
			p.getChildren().add(title);
			p.getChildren().add(label);
			
			//Layout Pane 2 from btn1 "top 20"
			Pane p2 = new Pane();
			p2.getChildren().add(btn3);
			p2.getChildren().add(top20);
			p2.getChildren().add(btnHome1);
			
			//Layout Pane 3 from btn2 "Full Poem"
			Pane p3 = new Pane();
			p3.getChildren().add(sp);
			p3.getChildren().add(btnHome2);
			
			
			scene = new Scene(p, 300, 250);
			scene2 = new Scene(p2, 400, 400);
			scene3 = new Scene(p3, 400, 400);
			
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handle(ActionEvent event) {
		if(event.getSource()==btn3) {
			WordParser wp = new WordParser();
			try {
				wp.wordParser();
				Scanner scan = new Scanner(new File("temp.txt"));
				String string = new String();
				
				while (scan.hasNext()) {
					string = scan.nextLine();
					top20.appendText(string + "\n");
				}
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			  try {
				post();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/words";
			String username = "Cristian";
			String password = "password";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}
		
		
		return null;
	}
	
	public static void post() throws Exception {
		
		final String var1 = "Johi";
		final String var2 = "909";		
		
		try {
			Connection con = getConnection();
			
			PreparedStatement posted;
			for (int i = 1; i < 20; i++) {
				posted = con.prepareStatement(
						"INSERT INTO word (word, frequency) VALUES ('"+var1+"', "+var2+")");
				
				posted.executeUpdate();
			}
		} catch (Exception e) {System.out.println(e); }
		finally {
			System.out.println("Insert Completed");
		}
	}
	
}
