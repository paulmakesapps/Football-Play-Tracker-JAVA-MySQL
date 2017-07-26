package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import DBConnect.DBConnect;
import Main.Main;

public class LoadSeasonUI extends Main{
Button[] schedule;

public String year;
public static final ObservableList names = 
FXCollections.observableArrayList();
public static final ObservableList data = 
FXCollections.observableArrayList();

public final DBConnect db = new DBConnect();

	public LoadSeasonUI(){
		
	}
	
	public void createLoadFrame(final Stage primaryStage) {

		Label otherseasonlbl = new Label("Select\nSeason:");
		otherseasonlbl.setLayoutX(20);
		otherseasonlbl.setLayoutY(60);
		
		
        final ListView listView = new ListView(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        
        
        //get data from the sql fakeseason list here
        String[] seasonArr=db.getSeasonList();
        
         
        for (int i = 0; i < seasonArr.length; i++) {
            if(seasonArr[i]!=null)
            	data.add(seasonArr[i]);
        }
		listView.setLayoutX(80);
		listView.setLayoutY(60);
		listView.setMaxHeight(150);
		listView.setMaxWidth(150);
        listView.setItems(data);


		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        year=newValue;
		    }
		});

		

		
		Button gobtn = new Button();
		gobtn.setText("Go");
		gobtn.setLayoutX(235);
		gobtn.setLayoutY(60);

		gobtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					//start(primaryStage);
				
						SeasonUI sui= new SeasonUI();
				
						if(year!=null){
						sui.create(primaryStage, year);
                                                listView.setItems(null);
                                                data.clear();
                                                }
								
			}
		});

		
		Button back = new Button();
		back.setText("Back");
		back.setLayoutX(10);
		back.setLayoutY(10);

		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					start(primaryStage);
			}
		});

		Pane root = new Pane();
		root.getChildren().add(back);
		root.getChildren().add(gobtn);
		root.getChildren().add(listView);
		root.getChildren().add(otherseasonlbl);



		scene = new Scene(root, 300, 250);

		primaryStage.setTitle("PlayPredictor");
		primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
		primaryStage.show();
	}	


}
