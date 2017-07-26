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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import DBConnect.DBConnect;
import Game.Game;
import Main.Main;
import Play.PlayTable;
import Game.GameTable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SeasonUI extends Main {

    private TableView<GameTable> table = new TableView<GameTable>();
    public ObservableList<GameTable> tabledata;
    public GameTable[] gamelist;

    Button[] schedule;
    public TextField name_field, home_field, away_field;
    public String gamename;
    public static final ObservableList names
            = FXCollections.observableArrayList();
    public static final ObservableList data
            = FXCollections.observableArrayList();
    public Game[] gamelistArr;

    public final DBConnect db = new DBConnect();

    public SeasonUI() {

    }

    public void create(final Stage primaryStage, final String seasonName) {

        gamelist = db.getGameTable(seasonName);

        tabledata = FXCollections
                .observableArrayList(gamelist);

        Label titleLBL = new Label(seasonName + " Season");
        titleLBL.setLayoutX(185);
        titleLBL.setLayoutY(8);
        titleLBL.setFont(new Font("Arial", 20));

        Label otherseasonlbl = new Label("Game \nList:");
        otherseasonlbl.setLayoutX(1113);
        otherseasonlbl.setLayoutY(80);

        //for addgame
        Label numlbl = new Label("Number");
        numlbl.setLayoutX(1113);
        numlbl.setLayoutY(300);

        name_field = new TextField();
        name_field.setLayoutX(1170);
        name_field.setLayoutY(300);

        Label homelbl = new Label("Home");
        homelbl.setLayoutX(1113);
        homelbl.setLayoutY(330);

        home_field = new TextField();
        home_field.setLayoutX(1170);
        home_field.setLayoutY(330);

        Label awaylbl = new Label("Away");
        awaylbl.setLayoutX(1113);
        awaylbl.setLayoutY(360);
        away_field = new TextField();
        away_field.setLayoutX(1170);
        away_field.setLayoutY(360);

        Button addbtn = new Button();
        addbtn.setText("Add Game");
        addbtn.setLayoutX(1175);
        addbtn.setLayoutY(390);

        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //start(primaryStage);
                if (!name_field.getText().matches("")
                        && !home_field.getText().matches("")
                        && !away_field.getText().matches("")) {

                    Game g = new Game(Integer.parseInt(seasonName),
                            Integer.parseInt(name_field.getText()), 0, 0,
                            home_field.getText(),
                            away_field.getText());
                    db.addNewGame(g, Integer.parseInt(seasonName));
                    name_field.setText("");
                    home_field.setText("");
                    away_field.setText("");

                    //reset list of games
                }

            }
        });

//this is all for the game number list//////////////////////////////////////
        final ListView listView = new ListView(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        //get data from the sql fakeseason list here
        gamelistArr = db.getGameNumber(seasonName);

        for (int i = 0; i < gamelistArr.length; i++) {
            if (gamelistArr[i] != null) {

                String cheat = gamelistArr[i].gamenumber + "";
                data.add(cheat);
            }
        }
        listView.setLayoutX(1170);
        listView.setLayoutY(80);
        listView.setMaxHeight(200);
        listView.setMaxWidth(150);
        listView.setItems(data);
//////////////////////////////////////////////////////////////////////

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                gamename = newValue;
            }
        });

        Button gobtn = new Button();
        gobtn.setText("Go");
        gobtn.setLayoutX(1113);
        gobtn.setLayoutY(120);

        gobtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                GameUI gui = new GameUI();
                for (int i = 0; i < gamelistArr.length; i++) {
                    if (gamelistArr[i] != null && gamename != null) {
                        if (gamelistArr[i].gamenumber == Integer.parseInt(gamename)) {
                            //make this all dynamicgamelistArr
                            gamelistArr[i].season = Integer.parseInt(seasonName);

                            gui.create(primaryStage, gamelistArr[i], Integer.parseInt(gamename));
                            table.setItems(null);
                            listView.setItems(null);
                            data.clear();

                        }
                    }
                }

            }
        });

        Button seasonlist = new Button();
        seasonlist.setText("Back");
        seasonlist.setLayoutX(10);
        seasonlist.setLayoutY(10);

        seasonlist.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        });

        tabledata = FXCollections.observableArrayList(gamelist);

        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(45);
        table.setMaxSize(500, 150);

        TableColumn gamenumber_tc = new TableColumn("Game Number");
        gamenumber_tc.setMinWidth(100);
        gamenumber_tc
                .setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
                        "gamenumber"));
        TableColumn home_tc = new TableColumn("Home Team");
        home_tc.setMinWidth(100);
        home_tc
                .setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
                        "home"));
        TableColumn away_tc = new TableColumn("Away Team");
        away_tc.setMinWidth(100);
        away_tc
                .setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
                        "away"));
        TableColumn homescore_tc = new TableColumn("Home Score");
        homescore_tc.setMinWidth(100);
        homescore_tc
                .setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
                        "homescore"));
        TableColumn awayscore_tc = new TableColumn("Away Score");
        awayscore_tc.setMinWidth(100);
        awayscore_tc
                .setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
                        "awayscore"));

        //table.setItems(tabledata);
        table.getColumns().addAll(gamenumber_tc, home_tc,
                away_tc, homescore_tc, awayscore_tc);
        table.setItems(tabledata);

        Pane root = new Pane();
        root.getChildren().add(table);
        root.getChildren().add(seasonlist);
        root.getChildren().add(titleLBL);
        root.getChildren().add(gobtn);
        root.getChildren().add(addbtn);

        root.getChildren().add(numlbl);
        root.getChildren().add(name_field);
        root.getChildren().add(homelbl);

        root.getChildren().add(home_field);
        root.getChildren().add(awaylbl);

        root.getChildren().add(away_field);

        root.getChildren().add(listView);
        root.getChildren().add(otherseasonlbl);

        scene = new Scene(root, 1480, 580);

        primaryStage.setTitle("PlayPredictor");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(false);
        primaryStage.setMaximized(true);

        primaryStage.show();
    }

}
