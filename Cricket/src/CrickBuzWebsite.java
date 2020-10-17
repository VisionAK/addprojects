/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import java.io.*;
public class CrickBuzWebsite extends Observer
{
    String team;
    double over;
    String user;
    FileWriter fw;
    public CrickBuzWebsite(String us)
    {
        this.user=us;
        try
        {
            this.fw=new FileWriter(this.user+".txt");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void update(String team1,String team2,String ttobstf, int fr, int fw, double fo, int sr, int sw, double so)
    {
        
        if(sr>0)
        {
            if(ttobstf!=null)
            {
                if(ttobstf.equalsIgnoreCase(team1))
                {
                    this.team=team2;
                }
                else
                {
                    this.team=team1;
                }
            }
            else
            {
                this.team=null;
            }
            
            this.over=so;
            
        }
        else
        {
            if(ttobstf!=null)
            {
                if(ttobstf.equalsIgnoreCase(team1))
                {
                    this.team=team1;
                }
                else
                {
                    this.team=team2;
                }
                
            } 
            else
            {
                this.team=null;
            }
            
             this.over=fo;
             
        }
        display();
    }
    public void display()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("CRICKBUZZ WEBSITE");
        System.out.println("USER WATCHING:"+this.user);
        System.out.println("THE TEAM BATTING:"+this.team+" OVERS:"+this.over);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        writeTofile();
        
    }
    public void writeTofile()
    {
        try
        {
            fw.close();
            fw=new FileWriter(this.user+".txt",true);
            fw.write("-----------------------------------------------------------------------------------------------------------------------\n");
            fw.append("CRICKBUZZ WEBSITE\n");
            fw.append("USER WATCHING:"+this.user+"\n");
            fw.append("THE TEAM BATTING:"+this.team+" OVERS:"+this.over+"\n");
            fw.append("-----------------------------------------------------------------------------------------------------------------------\n");

            fw.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
