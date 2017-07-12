package Play;

public class Play implements PlayInterface{
	public int down;
	public int tofirst;
	public String fieldside;
	public String team;
	public int yardlinestart;
	public int quarter;
	public int totalyards;
	public int yardlineend;
	public String playtype;
	public String direction;
	public double gameclock;
	public int gamenumber;
	public int homescore;
        public int awayscore;
        public int scoringplay;

    public Play(int down, int tofirst, String fieldside, 
            String team, int yardlinestart, int quarter, 
            int totalyards, int yardlineend, String playtype, 
            String direction, double gameclock, int gamenumber, 
            int homescore, int awayscore, int scoringplay) {
        this.down = down;
        this.tofirst = tofirst;
        this.fieldside = fieldside;
        this.team = team;
        this.yardlinestart = yardlinestart;
        this.quarter = quarter;
        this.totalyards = totalyards;
        this.yardlineend = yardlineend;
        this.playtype = playtype;
        this.direction = direction;
        this.gameclock = gameclock;
        this.gamenumber = gamenumber;
        this.homescore = homescore;
        this.awayscore = awayscore;
        this.scoringplay = scoringplay;
    }
	


}
