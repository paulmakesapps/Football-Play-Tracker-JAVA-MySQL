package UI;

import DBConnect.DBConnect;
import Main.Main;
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
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreateNewSeasonUI extends Main {

    Button[] schedule;
    public static final ObservableList names = FXCollections
            .observableArrayList();
    public static final ObservableList data = FXCollections
            .observableArrayList();

    public final DBConnect db = new DBConnect();
    boolean istableloaded = false;
    public TextField name_field;
    final ListView listViewLoad = new ListView(data);

    public CreateNewSeasonUI() {

    }

    public void createNewSeason(final Stage primaryStage) {

        Label lbl = new Label("New Year:");
        lbl.setLayoutX(10);
        lbl.setLayoutY(53);

        Label otherseasonlbl = new Label("Other \nSeasons:");
        otherseasonlbl.setLayoutX(10);
        otherseasonlbl.setLayoutY(80);

        name_field = new TextField();
        name_field.setLayoutX(70);
        name_field.setLayoutY(50);

        Button addbtn = new Button();
        addbtn.setText("Add");
        addbtn.setLayoutX(225);
        addbtn.setLayoutY(50);

        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                //add text to list in sql
//				System.out.println(">> ADD "+name_field.getText());
//				name_field.setText("");
//                                String hold=name_field.getText().toString();
                db.addNewSeason(name_field.getText());
                name_field.setText("");

                listViewLoad.setItems(null);
                data.clear();
                String[] seasonArr = db.getSeasonList();

                for (int i = 0; i < seasonArr.length; i++) {
                    if (seasonArr[i] != null) {
                        data.add(seasonArr[i]);
                    }
                }
                listViewLoad.setItems(data);

            }
        });

        listViewLoad.setPrefSize(200, 250);
        listViewLoad.setEditable(true);

        // get data from the sql fakeseason list here
        String[] seasonArr = db.getSeasonList();

        for (int i = 0; i < seasonArr.length; i++) {
            if (seasonArr[i] != null) {
                data.add(seasonArr[i]);
            }
        }

        listViewLoad.setLayoutX(70);
        listViewLoad.setLayoutY(80);
        listViewLoad.setMaxHeight(150);
        listViewLoad.setMaxWidth(150);
        listViewLoad.setItems(data);
        // listView.setCellFactory(ComboBoxListCell.forListView(names));

        Button okBtn = new Button("OK");
        Button closeBtn = new Button("Close");

        Button backbtn = new Button();
        backbtn.setText("Back");
        backbtn.setLayoutX(10);
        backbtn.setLayoutY(10);

        backbtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                start(primaryStage);
                listViewLoad.setItems(null);
                data.clear();

            }
        });

        Pane root = new Pane();
        root.getChildren().add(backbtn);
        root.getChildren().add(lbl);
        root.getChildren().add(name_field);
        root.getChildren().add(listViewLoad);
        root.getChildren().add(otherseasonlbl);
        root.getChildren().add(addbtn);

        scene = new Scene(root, 300, 250);

        primaryStage.setTitle("PlayPredictor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
