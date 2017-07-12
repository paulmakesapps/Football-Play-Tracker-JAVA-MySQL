/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Paul
 */

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GameTable{
	public SimpleIntegerProperty gamenumber;
        public SimpleIntegerProperty homescore;
	public SimpleIntegerProperty awayscore;
	public SimpleStringProperty home;
	public SimpleStringProperty away;


	public GameTable(int gamenumber_in, String home_in,
			String away_in,int homescore_in,int awayscore_in) {
		super();
		this.homescore = new SimpleIntegerProperty(homescore_in);
		this.awayscore = new SimpleIntegerProperty(awayscore_in);
		this.home = new SimpleStringProperty(home_in);
                this.away = new SimpleStringProperty(away_in);
		this.gamenumber = new SimpleIntegerProperty(gamenumber_in);
	}


	public String getHome() {
		return home.get();
	}

	public void setHome(String home_in) {
		home.set(home_in);
	}

	public String getAway() {
		return away.get();
	}

	public void setAway(String away_in) {
		away.set(away_in);
	}

	public int getHomescore() {
		return homescore.get();
	}

	public void setHomescore(int homescore_in) {
		homescore.set(homescore_in);
	}

	public int getAwayscore() {
		return awayscore.get();
	}

	public void setAwayscore(int awayscore_in) {
		awayscore.set(awayscore_in);
	}

	public int getGamenumber() {
		return gamenumber.get();
	}

	public void setGamenumber(int gamenumber_in) {
		gamenumber.set(gamenumber_in);
	}

}
