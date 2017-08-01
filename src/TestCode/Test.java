/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCode;

import DBConnect.DBConnect;
import Play.Play;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class Test {
    DBConnect db= new DBConnect();
    public Test(){
        
    }
    public void getPlays(){
       Play[] playarr;
        playarr=db.test();
    }
    
                public void intFrequency(){
                int[] lmnt = {2, 2, 2, 2, 2, 4, 4, 3, 8, 8, 8, 8, 8, 8, 8, 8, 4, 4, 4, 4, 44, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8};
        int topcount = 1;
        int second = 1;
        int third;

        int tempcount = 0;
        int popular = 0;
        int secondpop = 0;
        int thirdpop = 0;

        for (int x = 0; x < lmnt.length; x++) {
            /// System.out.println(">> "+lmnt[x]);

            tempcount = 0;
            for (int i = 0; i < lmnt.length; i++) {
                if (lmnt[i] == lmnt[x]) {
                    tempcount++;
                }
            }
            //subtract 1 because it re counts itself
            tempcount--;
            if (tempcount > topcount) {
                second = topcount;
                topcount = tempcount;
                thirdpop = secondpop;
                secondpop = popular;
                popular = lmnt[x];
            }

        }
        System.out.println("Top: " + popular);
        System.out.println("Second: " + secondpop);
        System.out.println("Third: " + thirdpop);

        //compare to random number
        Random rand = new Random();

        for (int zz = 0; zz < 20; zz++) {
            int n = rand.nextInt(29) + 0;
            System.out.println("Random " + zz + ": " + lmnt[n]);
        }

        //System.out.println(getPopularElement(lmt,playsheet.plays));

    }

}
