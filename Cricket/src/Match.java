
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Match extends IplMatch
{
    public Match()
    {
        team1=team2=teamtobatfirst=null;
        fruns=fwickets=0;
        fovers=0;
        sruns=swickets=0;
        sovers=0;
        
        list=new ArrayList<Observer>();
    }
    
    public void setTeam1(String t1)
    {
        this.team1=t1;
        notifyObserver();
    }
    public void setTeam2(String t2)
    {
        this.team2=t2;
        notifyObserver();
    }
    public void setTeamToBatFirst(String btf)
    {
        this.teamtobatfirst=btf;
        notifyObserver();
    }
    public void setFirstInningsScore(int r,int w,double o)
    {
        this.fovers=o;
        this.fruns=r;
        this.fwickets=w;
        notifyObserver();
    }
     public void setSecondInningsScore(int r,int w,double o)
    {
        this.sovers=o;
        this.sruns=r;
        this.swickets=w;
        notifyObserver();
    }
     
    public void addObserver(Observer ob)
    {
       list.add(ob);
    }
    public void removeObserver(Observer ob)
    {
        list.remove(ob);
    }
    
    public void notifyObserver() 
    {
        for(Observer l:list)
        {
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            l.update(team1, team2, teamtobatfirst, fruns, fwickets, fovers, sruns, swickets, sovers);
        }
    }
}
