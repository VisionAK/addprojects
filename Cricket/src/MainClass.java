/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MainClass 
{
    public static void main(String[] args)
    {
         Observer user1=new CrickBuzzApp("USER1");
         Observer user2=new CrickBuzzApp("USER2");
         Observer user3=new CrickBuzWebsite("USER3");
         Observer user4=new CrickBuzWebsite("USER4");
         
         Match cskvsrr=new Match();
         cskvsrr.addObserver(user1);
         cskvsrr.addObserver(user3);
         
         cskvsrr.setTeam1("CSK");
         cskvsrr.setTeam2("RR");
         cskvsrr.setTeamToBatFirst("RR");
         cskvsrr.setFirstInningsScore(215, 7, 20);
         cskvsrr.setSecondInningsScore(25, 0, 2);
         cskvsrr.setSecondInningsScore(55, 0, 7);
           Match kkrvsmi=new Match();
           kkrvsmi.addObserver(user4);
           kkrvsmi.addObserver(user1);
           kkrvsmi.addObserver(user2);
           kkrvsmi.setTeam1("KKR");
           kkrvsmi.setTeam2("MI");
           kkrvsmi.setTeamToBatFirst("MI");
           kkrvsmi.setFirstInningsScore(89, 1, 9);
           kkrvsmi.setFirstInningsScore(189, 5, 20);
           kkrvsmi.setSecondInningsScore(40, 0, 3);
           kkrvsmi.setSecondInningsScore(80, 0, 9);
    }
}
