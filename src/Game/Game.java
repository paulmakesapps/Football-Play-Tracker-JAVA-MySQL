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
public class Game {
    	public int gamenumber;
        public int homescore;
	public int awayscore;
	public String home;
	public String away;
        public int season;

    public Game(int season,int gamenumber,int homescore, int awayscore,String home, String away) {
        this.gamenumber = gamenumber;
        this.homescore = homescore;
        this.awayscore = awayscore;
                this.home = home;
        this.away = away;

    }

}
