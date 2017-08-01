package Main;

import TestCode.Test;
import java.awt.EventQueue;

import UI.CreateNewSeasonUI;
import UI.LoadSeasonUI;
import UI.PlayUI;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Button newseason, seasonlist;
	public Scene scene;

	@Override
	public void start(Stage primaryStage) {

		initMain(primaryStage);

		Pane root = new Pane();
		root.getChildren().add(newseason);
		root.getChildren().add(seasonlist);
		root.setStyle("-fx-background-color: #FFFFFF;");

		scene = new Scene(root, 300, 250);

		primaryStage.setTitle("PlayPredictor");
		primaryStage.setScene(scene);
                
		primaryStage.show();
	}

	public void initMain(final Stage primaryStage) {

		newseason = new Button();
		newseason.setText("New Season");

		newseason.setLayoutX(210);
		newseason.setLayoutY(10);


		newseason.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				CreateNewSeasonUI cns=new CreateNewSeasonUI();
				
				cns.createNewSeason(primaryStage);

			}
		});

		seasonlist = new Button();
		seasonlist.setText("Load Season");
		seasonlist.setLayoutX(10);
		seasonlist.setLayoutY(10);

		seasonlist.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				LoadSeasonUI lsu =new LoadSeasonUI();
				
				lsu.createLoadFrame(primaryStage);

//				this code loads the play creator
				
//				try {
//					PlayUI frame = new PlayUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}

			}
		});

	}
	

	public static void main(String[] args) {
		//launch(args);
                
                //intFrequency();
                Test t= new Test();
                t.getPlays();
                
                
	}
        

}