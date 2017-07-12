package Play;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayTable implements PlayInterface {
	public SimpleIntegerProperty down;
	public SimpleIntegerProperty tofirst;
	public SimpleStringProperty fieldside;
	public SimpleStringProperty team;
	public SimpleIntegerProperty yardlinestart;
	public SimpleIntegerProperty quarter;
	public SimpleIntegerProperty totalyards;
	public SimpleIntegerProperty yardlineend;
	public SimpleStringProperty playtype;
	public SimpleStringProperty direction;
	public SimpleDoubleProperty gameclock;
	public SimpleIntegerProperty gamenumber;
        public SimpleIntegerProperty homescore;
	public SimpleIntegerProperty awayscore;
	public SimpleIntegerProperty scoringplay;


	// add currentscore for home and away

	public PlayTable(int down_in, int tofirst_in, String fieldside_in,
			String team_in, int yardlinestart_in, int quarter_in,
			int totalyards_in, int yardlineend_in, String playtype_in,
			String direction_in, double gameclock_in, int gamenumber_in,
                        int homescore_in,int awayscore_in,int scoringplay_in) {
            
		super();
		this.down = new SimpleIntegerProperty(down_in);
		this.tofirst = new SimpleIntegerProperty(tofirst_in);
		this.fieldside = new SimpleStringProperty(fieldside_in);
		this.team = new SimpleStringProperty(team_in);
		this.yardlinestart = new SimpleIntegerProperty(yardlinestart_in);
		this.quarter = new SimpleIntegerProperty(quarter_in);
		this.totalyards = new SimpleIntegerProperty(totalyards_in);
		this.yardlineend = new SimpleIntegerProperty(yardlineend_in);
		this.playtype = new SimpleStringProperty(playtype_in);
		this.direction = new SimpleStringProperty(direction_in);
		this.gameclock = new SimpleDoubleProperty(gameclock_in);
		this.gamenumber = new SimpleIntegerProperty(gamenumber_in);
                this.homescore = new SimpleIntegerProperty(homescore_in);
		this.awayscore = new SimpleIntegerProperty(awayscore_in);
		this.scoringplay = new SimpleIntegerProperty(scoringplay_in);

	}

	public double getGameclock() {
		return gameclock.get();
	}

	public void setGameclock(double gameclock_in) {
		gameclock.set(gameclock_in);
	}

	public String getDirection() {
		return direction.get();
	}

	public void setDirection(String direction_in) {
		direction.set(direction_in);
	}

	public String getPlaytype() {
		return playtype.get();
	}

	public void setPlaytype(String playtype_in) {
		playtype.set(playtype_in);
	}

	public int getGamenumber() {
		return gamenumber.get();
	}

	public void setGamenumber(int gamenumber_in) {
		gamenumber.set(gamenumber_in);
	}

	public int getYardlineend() {
		return yardlineend.get();
	}

	public void setYardlineend(int yardlineend_in) {
		yardlineend.set(yardlineend_in);
	}

	public int getTotalyards() {
		return totalyards.get();
	}

	public void setTotalyards(int totalyards_in) {
		totalyards.set(totalyards_in);
	}

	public int getQuarter() {
		return quarter.get();
	}

	public void setQuarter(int quarter_in) {
		quarter.set(quarter_in);
	}

	public int getYardlinestart() {
		return yardlinestart.get();
	}

	public void setYardlinestart(int yardlinestart_in) {
		yardlinestart.set(yardlinestart_in);
	}

	public String getTeam() {
		return team.get();
	}

	public void setTeam(String team_in) {
		team.set(team_in);
	}

	public String getFieldside() {
		return fieldside.get();
	}

	public void setFieldside(String fieldside_in) {
		fieldside.set(fieldside_in);
	}

	public int getTofirst() {
		return tofirst.get();
	}

	public void setTofirst(int tofirst_in) {
		tofirst.set(tofirst_in);
	}

	public int getDown() {
		return down.get();
	}

	public void setDown(int down_in) {
		down.set(down_in);
	}
        
        public int getHomescore() {
		return homescore.get();
	}

	public void setHomescore(int homescore_in) {
		down.set(homescore_in);
	}
        
        public int getAwayscore() {
		return awayscore.get();
	}

	public void setAwayscore(int awayscore_in) {
		down.set(awayscore_in);
	}
        
               
        public int getScoringplay() {
		return scoringplay.get();
	}

	public void setScoringplay(int scoringplay_in) {
		down.set(scoringplay_in);
	}




}
