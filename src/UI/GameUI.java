package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import DBConnect.DBConnect;
import Game.Game;
import Main.Main;
import Play.Play;
import Play.PlayTable;
import javafx.scene.control.RadioButton;

public class GameUI extends Main {
public PlayTable[] playlist;
	private TableView<PlayTable> table = new TableView<PlayTable>();

	Button[] schedule;
	public static final ObservableList names = FXCollections
			.observableArrayList();
	public static final ObservableList data = FXCollections
			.observableArrayList();

	public ObservableList<PlayTable> tabledata;

	public final DBConnect db = new DBConnect();

	public GameUI() {

	}

	public void create(final Stage primaryStage,final Game gameIN,final int gamenumber) {
		
            //make all of this dynamic
                String season="2017";
                String gamenum=gamenumber+"";
                
		playlist=db.getPlayTable(season,gamenum);
		
		tabledata = FXCollections
				.observableArrayList(playlist);
		
		
		
		
		Label titleLBL = new Label(gameIN.home+" VS "+gameIN.away);
		titleLBL.setLayoutX(580);
		titleLBL.setLayoutY(8);
		titleLBL.setFont(new Font("Arial", 25));

		Button seasonlist = new Button();
		seasonlist.setText("Back");
		seasonlist.setLayoutX(10);
		seasonlist.setLayoutY(10);

		seasonlist.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				start(primaryStage);
			}
		});

		Button addplay = new Button();
		addplay.setText("Add Play");
		addplay.setLayoutX(1180);
		addplay.setLayoutY(10);

		addplay.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					PlayUI frame = new PlayUI(gameIN);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		table.setEditable(true);
		table.setLayoutX(45);
		table.setLayoutY(55);
                table.setMaxSize(2075, 1145);

		TableColumn gamenumber_tc = new TableColumn("Game Number");
		gamenumber_tc.setMinWidth(80);
		gamenumber_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"gamenumber"));

		TableColumn gameclock_tc = new TableColumn("Game Clock");
		gameclock_tc.setMinWidth(80);
		gameclock_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Double>(
						"gameclock"));

		TableColumn quarter_tc = new TableColumn("Quarter");
		quarter_tc.setMinWidth(70);
		quarter_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"quarter"));

		 TableColumn homescore_tc = new TableColumn(gameIN.home+" Score");
		 homescore_tc.setMinWidth(100);
		 homescore_tc
		 .setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
		 "homescore"));
                 		 TableColumn awayscore_tc = new TableColumn(gameIN.away+" Score");
		 awayscore_tc.setMinWidth(100);
		 awayscore_tc
		 .setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
		 "awayscore"));


		TableColumn team_tc = new TableColumn("Posession");
		team_tc.setMinWidth(100);
		team_tc.setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
				"team"));
		TableColumn fieldside_tc = new TableColumn("Field Side");
		fieldside_tc.setMinWidth(100);
		fieldside_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
						"fieldside"));

		TableColumn down_tc = new TableColumn("Down");
		down_tc.setMinWidth(60);
		down_tc.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
				"down"));

		TableColumn tofirst_tc = new TableColumn("Yards to First");
		tofirst_tc.setMinWidth(100);
		tofirst_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"tofirst"));
		TableColumn yardlinestart_tc = new TableColumn(
				"YardLine Start");
		yardlinestart_tc.setMinWidth(100);
		yardlinestart_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"yardlinestart"));

		TableColumn playtype_tc = new TableColumn("Playtype");
		playtype_tc.setMinWidth(60);
		playtype_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
						"playtype"));

		TableColumn direction_tc = new TableColumn("Direction");
		direction_tc.setMinWidth(80);
		direction_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, String>(
						"direction"));

		TableColumn totalyards_tc = new TableColumn("Yards Gained");
		totalyards_tc.setMinWidth(100);
		totalyards_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"totalyards"));

		TableColumn yardlineend_tc = new TableColumn("Yard Line at End of Play");
		yardlineend_tc.setMinWidth(100);
		yardlineend_tc
				.setCellValueFactory(new PropertyValueFactory<PlayTable, Integer>(
						"yardlineend"));


		table.setItems(tabledata);

		table.getColumns().addAll(gamenumber_tc, quarter_tc, gameclock_tc,homescore_tc,awayscore_tc,
				team_tc, fieldside_tc, down_tc, tofirst_tc, yardlinestart_tc,
				playtype_tc, direction_tc, totalyards_tc, yardlineend_tc);
                
                







		Pane root = new Pane();
		root.getChildren().add(seasonlist);
		root.getChildren().add(titleLBL);
		root.getChildren().add(table);
		root.getChildren().add(addplay);
                    setRadioButtons(root,gameIN);


		scene = new Scene(root, 1480, 600);

		primaryStage.setTitle("PlayPredictor");
		primaryStage.setScene(scene);
                primaryStage.setMaximized(false);
                primaryStage.setMaximized(true);

		primaryStage.show();
	}
        public void setRadioButtons(Pane root, Game gameIN){
            //Radio Buttons
                
                RadioButton gamenumber_rb = new RadioButton("Gamenumber");
		gamenumber_rb.setLayoutX(1000);
		gamenumber_rb.setLayoutY(465);
                RadioButton quarter_rb = new RadioButton("Quarter");
		quarter_rb.setLayoutX(1100);
		quarter_rb.setLayoutY(465);
                RadioButton gameclock_rb = new RadioButton("Game Clock");
		gameclock_rb.setLayoutX(1210);
		gameclock_rb.setLayoutY(465);
                RadioButton homescore_rb = new RadioButton(gameIN.home+" Homescore");
		homescore_rb.setLayoutX(1000);
		homescore_rb.setLayoutY(490);
                RadioButton awayscore_rb = new RadioButton(gameIN.away+" Score");
		awayscore_rb.setLayoutX(1210);
		awayscore_rb.setLayoutY(490);
                RadioButton team_rb = new RadioButton("Posession");
		team_rb.setLayoutX(1000);
		team_rb.setLayoutY(515);
                RadioButton fieldside_rb = new RadioButton("Field Side");
		fieldside_rb.setLayoutX(1100);
		fieldside_rb.setLayoutY(515);
                RadioButton down_rb = new RadioButton("Down");
		down_rb.setLayoutX(1210);
		down_rb.setLayoutY(515);
                
                                RadioButton tofirst_rb = new RadioButton("To First");
		tofirst_rb.setLayoutX(1000);
		tofirst_rb.setLayoutY(540);
                RadioButton yardlinestart_rb = new RadioButton("Yard Line Start");
		yardlinestart_rb.setLayoutX(1100);
		yardlinestart_rb.setLayoutY(540);
                RadioButton playtype_rb = new RadioButton("Playtype");
		playtype_rb.setLayoutX(1210);
		playtype_rb.setLayoutY(540);
                
                                                RadioButton direction_rb = new RadioButton("Direction");
		direction_rb.setLayoutX(1000);
		direction_rb.setLayoutY(565);
                RadioButton totalyards_rb = new RadioButton("Total Yards");
		totalyards_rb.setLayoutX(1100);
		totalyards_rb.setLayoutY(565);
                RadioButton yardlineend_rb = new RadioButton("Yard Line End");
		yardlineend_rb.setLayoutX(1210);
		yardlineend_rb.setLayoutY(565);
                
                		Button rbselect = new Button();
		rbselect.setText("Remove Columns");
		rbselect.setLayoutX(1210);
		rbselect.setLayoutY(590);

		rbselect.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

                //System.out.println(yardlineend_rb.


                        }
		});
                
                                		root.getChildren().add(gamenumber_rb);
                		root.getChildren().add(quarter_rb);
                		root.getChildren().add(gameclock_rb);
                		root.getChildren().add(homescore_rb);
                		root.getChildren().add(awayscore_rb);
                		root.getChildren().add(team_rb);
                		root.getChildren().add(fieldside_rb);
                		root.getChildren().add(down_rb);
                                root.getChildren().add(yardlinestart_rb);
                		root.getChildren().add(tofirst_rb);
                		root.getChildren().add(playtype_rb);
                                root.getChildren().add(direction_rb);
                		root.getChildren().add(totalyards_rb);
                		root.getChildren().add(yardlineend_rb);
                		root.getChildren().add(rbselect);

        }

}
