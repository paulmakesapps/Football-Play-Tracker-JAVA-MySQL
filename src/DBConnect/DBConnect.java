package DBConnect;

import Game.Game;
import Game.GameTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Play.Play;
import Play.PlayTable;

public class DBConnect {

    public DBConnect() {

    }

    public void addNewGame(Game g, int season) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO gamelist" + season + " VALUES(" + season + "," + g.gamenumber
                    + ",0,0,'" + g.home + "','" + g.away + "');");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Play[] test() {
        Play[] playarr= new Play[300];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from playlist2017 where gamenumber =1 ;");
            
                        System.out.printf("%s %10s %10s %7s  %10s %8s %10s %10s %10s %10s %10s \n", "Down", "ToFirst", "FieldSide", "Team", "Yard Line Start", "Quarter", "Total Yards", "Yard Line End", "Play Type", "Direction", "GameClock");
            System.out.printf("%s %10s %10s %7s  %10s %8s %10s %10s %10s %10s %10s \n", "----", "-------", "---------", "----", "---------------", "-------", "-----------", "-------------", "---------", "---------", "---------");

              while (rs.next()) {
                System.out.printf("%3s %10s %10s %10s %10s %10s %10s %10s %15s %10s %10s %15s %10s %10s \n", rs.getString(1), rs.getString(2),
                         rs.getString(3), rs.getString(4), rs.getString(5),
                         rs.getString(6), rs.getString(7), rs.getString(8),
                         rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
return playarr;
    }

    public void addPlay(Play p, Game game) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            Statement stmt = con.createStatement();

            int rs = stmt.executeUpdate("INSERT INTO playlist" + game.season + " VALUES(" + p.down + "," + p.tofirst + ",'" + p.fieldside + "','" + p.team + "'," + p.yardlinestart + "," + p.quarter + "," + p.totalyards + "," + p.yardlineend + ",'" + p.playtype + "','" + p.direction + "'," + p.gameclock + "," + p.gamenumber + "," + p.homescore + "," + p.awayscore + "," + p.scoringplay + ");");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void getPlay() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from fakeplay");

            //testing print statement
            System.out.printf("%s %10s %10s %7s  %10s %8s %10s %10s %10s %10s %10s \n", "Down", "ToFirst", "FieldSide", "Team", "Yard Line Start", "Quarter", "Total Yards", "Yard Line End", "Play Type", "Direction", "GameClock");
            System.out.printf("%s %10s %10s %7s  %10s %8s %10s %10s %10s %10s %10s \n", "----", "-------", "---------", "----", "---------------", "-------", "-----------", "-------------", "---------", "---------", "---------");
            while (rs.next()) {
                System.out.printf("%3s %10s %10s %10s %10s %10s %10s %10s %15s %10s %10s \n", rs.getString(1), rs.getString(2),
                         rs.getString(3), rs.getString(4), rs.getString(5),
                         rs.getString(6), rs.getString(7), rs.getString(8),
                         rs.getString(9), rs.getString(10), rs.getString(11));
            }
//			
//			Play playIN = new Play
//				(		
//			Integer.parseInt(rs.getString(1)),
//			Integer.parseInt(rs.getString(2)),
//			rs.getString(3),
//			rs.getString(4),
//			Integer.parseInt(rs.getString(5)),
//			Integer.parseInt(rs.getString(6)),
//			Integer.parseInt(rs.getString(7)),
//			Integer.parseInt(rs.getString(8)),
//			rs.getString(9),
//			rs.getString(10),
//			Double.parseDouble((rs.getString(11)))
//			);

            //System.out.println(">> "+playIN.quarter);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public PlayTable[] getPlayTable(String season, String game) {
        PlayTable[] returntable = new PlayTable[100];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from playlist" + season + " where gamenumber = " + game + " ;");

            int i = 0;
            while (rs.next()) {

                int zz = Integer.parseInt(rs.getString(1));
                System.out.println(zz);
//			
                int down = Integer.parseInt(rs.getString(1));
                int tofirst = Integer.parseInt(rs.getString(2));
                String fieldside = rs.getString(3);
                String team = rs.getString(4);
                int yardlinestart = Integer.parseInt(rs.getString(5));
                int quarter = Integer.parseInt(rs.getString(6));
                int totalyards = Integer.parseInt(rs.getString(7));
                int yardlineend = Integer.parseInt(rs.getString(8));
                String playtype = rs.getString(9);
                String direction = rs.getString(10);
                double gameclock = Double.parseDouble(rs.getString(11));
                int gamenumber = Integer.parseInt(rs.getString(12));
                int homescore = Integer.parseInt(rs.getString(13));
                int awayscore = Integer.parseInt(rs.getString(14));
                int scoringplay = Integer.parseInt(rs.getString(15));

                PlayTable holds = new PlayTable(down, tofirst, fieldside,
                        team, yardlinestart, quarter,
                        totalyards, yardlineend, playtype,
                        direction, gameclock, gamenumber,
                        homescore, awayscore, scoringplay);

                returntable[i] = holds;
                i++;
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return returntable;
    }

    public void addNewSeason(String season) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            Statement stmt = con.createStatement();

            int rs = stmt.executeUpdate("INSERT INTO seasonlist VALUES(" + season + ");");
rs = stmt.executeUpdate("CREATE TABLE playlist"+season+"(down INTEGER ,tofirst Integer,fieldside VARCHAR(10),team VARCHAR(30),yardlinestart INTEGER,quarter INTEGER,totalyards INTEGER,yardlineend INTEGER,playtype VARCHAR(4),direction VARCHAR(7),playclock DOUBLE,gamenumber INTEGER,homescore INTEGER,awayscore INTEGER,scoringplay INTEGER);");
rs=stmt.executeUpdate("create table gamelist"+season+"(season INTEGER,gamenumber INTEGER,homescore INTEGER,awayscore INTEGER,home VARCHAR(40),away VARCHAR(40));");            
            
            
            
            
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String[] getSeasonList() {
        String[] seasonlist = new String[100];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here is database name, root is username and password
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from seasonlist;");

            int zz = 0;
            while (rs.next()) {
                seasonlist[zz] = rs.getString(1);
                zz++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return seasonlist;

    }

    public Game[] getGameNumber(String season) {
        Game[] gamelist = new Game[30];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from gamelist" + season + ";");
            System.out.println(season);
            int zz = 0;
            while (rs.next()) {
                int seasonIN = Integer.parseInt(rs.getString(1));
                int gamenumber = Integer.parseInt(rs.getString(2));
                int homescore = Integer.parseInt(rs.getString(3));
                int awayscore = Integer.parseInt(rs.getString(4));
                String home = rs.getString(5);
                String away = rs.getString(6);

                Game hold = new Game(seasonIN, gamenumber, homescore, awayscore, home, away);
                gamelist[zz] = hold;
                zz++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return gamelist;

    }

    public GameTable[] getGameTable(String season) {
        GameTable[] returntable = new GameTable[100];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabase", "root", "nopass");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from gamelist" + season + " ;");

            int i = 0;
            while (rs.next()) {
                int seasonIN = Integer.parseInt(rs.getString(1));
                int gamenumber = Integer.parseInt(rs.getString(2));
                int homescore = Integer.parseInt(rs.getString(3));
                int awayscore = Integer.parseInt(rs.getString(4));
                String home = rs.getString(5);
                String away = rs.getString(6);
                System.out.println(">> " + gamenumber + " " + home + " " + away + " " + homescore + awayscore);

                GameTable holds = new GameTable(gamenumber, home,
                        away, homescore, awayscore);

                returntable[i] = holds;
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return returntable;
    }

}
