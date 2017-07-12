package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import DBConnect.DBConnect;
import Game.Game;
import Play.Play;

public class PlayUI extends JFrame implements ActionListener {
	JPanel playpanel;
	JTextField yardlinestart_tb,homescore_tb,awayscore_tb;
	JTextField totalyards_tb;
	JTextField yardlineend_tb;
	JTextField tofirst_tb, gameclock_tb;
	JComboBox quarter_cb;
	JButton submit;
	JComboBox down_cb;
	JComboBox fieldside_cb;
	JComboBox team_cb;
	JComboBox playtype_cb;
	JComboBox direction_cb;
JComboBox scoringplay_cb;
	JComboBox down_cbx;
public int gamenumber_in;
public Game gamecopy;
        //this needs to take in the season name, hometeam name, awayteamname
	public PlayUI(final Game gameIN) {
	
            gamecopy=gameIN;
            gamenumber_in=gameIN.gamenumber;
            
            String[] downArr = { "1", "2", "3", "4" };
		String[] quarterArr = { "1", "2", "3", "4" };
		String[] fieldsideArr = { "Opposing", "Own" };
		String[] teamArr = { gameIN.home, gameIN.away };
		String[] playtypeArr = { "Run", "Pass" };
		String[] directionArr = { "Left", "Right", "Middle" };
                String[] scoreArr = { "No", "Yes"};


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		playpanel = new JPanel();
		playpanel.setForeground(new Color(204, 0, 204));
		playpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(playpanel);
		playpanel.setLayout(null);

		submit = new JButton("Submit");
		submit.setBounds(320, 227, 100, 23);
		submit.addActionListener(this);
		playpanel.add(submit);

		yardlinestart_tb = new JTextField();
		yardlinestart_tb.setBounds(99, 163, 78, 20);
		playpanel.add(yardlinestart_tb);
		yardlinestart_tb.setColumns(10);

		down_cb = new JComboBox(downArr);
		down_cb.setBounds(99, 45, 78, 20);
		playpanel.add(down_cb);

		totalyards_tb = new JTextField();
		totalyards_tb.setBounds(331, 45, 46, 20);
		playpanel.add(totalyards_tb);
		totalyards_tb.setColumns(10);

		JLabel lblYardLineStart = new JLabel("Yard Line Start");
		lblYardLineStart.setBounds(10, 163, 86, 14);
		playpanel.add(lblYardLineStart);

		JLabel lblYardLineEnd = new JLabel("Total Yards");
		lblYardLineEnd.setBounds(243, 45, 89, 14);
		playpanel.add(lblYardLineEnd);

		JLabel lblDown = new JLabel("Down");
		lblDown.setBounds(10, 48, 46, 14);
		playpanel.add(lblDown);

		JLabel lblTost = new JLabel("To 1st");
		lblTost.setBounds(10, 80, 46, 14);
		playpanel.add(lblTost);

		JLabel lblPrePlay = new JLabel("Pre Play");
		lblPrePlay.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		lblPrePlay.setBounds(10, 11, 110, 23);
		playpanel.add(lblPrePlay);

		JLabel lblPostPlay = new JLabel("Post Play");
		lblPostPlay.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		lblPostPlay.setBounds(243, 11, 92, 23);
		playpanel.add(lblPostPlay);

		fieldside_cb = new JComboBox(fieldsideArr);
		fieldside_cb.setBounds(99, 101, 78, 20);
		playpanel.add(fieldside_cb);

		JLabel lblFieldSide = new JLabel("Field Side");
		lblFieldSide.setBounds(10, 104, 72, 14);
		playpanel.add(lblFieldSide);

		JLabel lblWhoHasBall = new JLabel("Team");
		lblWhoHasBall.setBounds(10, 132, 86, 14);
		playpanel.add(lblWhoHasBall);

		team_cb = new JComboBox(teamArr);
		team_cb.setBounds(99, 132, 78, 20);
		playpanel.add(team_cb);

		JLabel lblYardLineEnd_1 = new JLabel("Yard Line End");
		lblYardLineEnd_1.setBounds(243, 101, 89, 14);
		playpanel.add(lblYardLineEnd_1);

		yardlineend_tb = new JTextField();
		yardlineend_tb.setBounds(331, 101, 46, 20);
		playpanel.add(yardlineend_tb);
		yardlineend_tb.setColumns(10);

		tofirst_tb = new JTextField();
		tofirst_tb.setBounds(99, 77, 78, 20);
		playpanel.add(tofirst_tb);
		tofirst_tb.setColumns(10);

		playtype_cb = new JComboBox(playtypeArr);
		playtype_cb.setBounds(331, 129, 57, 20);
		playpanel.add(playtype_cb);

		JLabel lblPlaytype = new JLabel("Playtype");
		lblPlaytype.setBounds(243, 132, 89, 14);
		playpanel.add(lblPlaytype);

		JLabel lblDirection = new JLabel("Direction");
		lblDirection.setBounds(243, 166, 89, 14);
		playpanel.add(lblDirection);

		direction_cb = new JComboBox(directionArr);
		direction_cb.setBounds(331, 160, 57, 20);
		playpanel.add(direction_cb);

		JLabel lblgameclock = new JLabel("Time of Snap");
		lblgameclock.setBounds(243, 194, 89, 14);
		playpanel.add(lblgameclock);

		gameclock_tb = new JTextField();
		gameclock_tb.setBounds(331, 191, 57, 20);
		playpanel.add(gameclock_tb);
		gameclock_tb.setColumns(10);
		JLabel lblminsec = new JLabel("(00.00)");
		lblminsec.setBounds(331, 211, 57, 14);
		playpanel.add(lblminsec);
		
		 quarter_cb = new JComboBox(quarterArr);
		quarter_cb.setBounds(331, 71, 52, 23);
		playpanel.add(quarter_cb);
		
		JLabel lblPenalty = new JLabel("Quarter");
		lblPenalty.setBounds(243, 70, 57, 14);
		playpanel.add(lblPenalty);
                
                homescore_tb = new JTextField();
		homescore_tb.setBounds(99, 191, 78, 20);
		playpanel.add(homescore_tb);
		homescore_tb.setColumns(10);
		
		JLabel lblHomeScore = new JLabel(gameIN.home+" Score");
		lblHomeScore.setBounds(10, 188, 72, 14);
		playpanel.add(lblHomeScore);
		
		awayscore_tb= new JTextField();
		awayscore_tb.setBounds(99, 227, 78, 20);
		playpanel.add(awayscore_tb);
		awayscore_tb.setColumns(10);
		
		JLabel lblAwayScore = new JLabel(gameIN.away+" Score");
		lblAwayScore.setBounds(10, 230, 72, 14);
		playpanel.add(lblAwayScore);
		
		JLabel lblTd = new JLabel("TD?");
		lblTd.setBounds(211, 230, 46, 14);
		playpanel.add(lblTd);
		
		 scoringplay_cb = new JComboBox(scoreArr);
		scoringplay_cb.setBounds(243, 227, 57, 20);
		playpanel.add(scoringplay_cb);


	}

	public void actionPerformed(ActionEvent event) {

		int down;
		int tofirst = 0;
		String fieldside;
		String team;
		int yardlinestart = 0;

		int quarter=0;
		int totalyards = 0;
		int yardlineend = 0;
		String playtype;
		String direction;
		double gameclock = 0;
		int gamenumber=gamenumber_in;
                int homescore=0;
		int awayscore=0;
		int scoringplay=0;


		if (event.getSource() == submit) {

			down = Integer.parseInt(down_cb.getSelectedItem().toString());

			if (tofirst_tb.getText().toString().isEmpty() == false)
				tofirst = Integer.parseInt(tofirst_tb.getText().toString());

			fieldside = (fieldside_cb.getSelectedItem().toString());
			team = (team_cb.getSelectedItem().toString());

			if (yardlinestart_tb.getText().toString().isEmpty() == false)
				yardlinestart = Integer.parseInt(yardlinestart_tb.getText()
						.toString());

			if (totalyards_tb.getText().toString().isEmpty() == false)
				totalyards = Integer.parseInt(totalyards_tb.getText()
						.toString());

			if (yardlineend_tb.getText().toString().isEmpty() == false)
				yardlineend = Integer.parseInt(yardlineend_tb.getText()
						.toString());

			playtype = playtype_cb.getSelectedItem().toString();
			direction = direction_cb.getSelectedItem().toString();
			quarter = Integer.parseInt(quarter_cb.getSelectedItem().toString());


			if (gameclock_tb.getText().toString().isEmpty() == false)
				gameclock = Double.parseDouble(gameclock_tb.getText()
						.toString());
                        if (homescore_tb.getText().toString().isEmpty() == false)
				homescore = Integer.parseInt(homescore_tb.getText()
						.toString());
                        if (awayscore_tb.getText().toString().isEmpty() == false)
				awayscore = Integer.parseInt(awayscore_tb.getText()
						.toString());
                        
                        scoringplay= scoringplay_cb.getSelectedIndex();
                        
			Play p = new Play(down, tofirst, fieldside, team, yardlinestart,quarter,
							  totalyards, yardlineend, playtype, direction, 
                                                gameclock,gamenumber,homescore,awayscore,scoringplay);
		
			DBConnect db= new DBConnect();

                       // String season= gamecopy.season;
			db.addPlay(p,gamecopy);

                        totalyards_tb.setText("");
                        yardlineend_tb.setText("");
                        gameclock_tb.setText("");
                        yardlinestart_tb.setText(""+yardlineend);
                        tofirst_tb.setText("");

		}

	}

}
