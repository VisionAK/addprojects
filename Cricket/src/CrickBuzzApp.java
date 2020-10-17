
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class CrickBuzzApp extends Observer
{
    String user;
    double currentrunraate,reqrunraate;
    int predictedscore;
    FileWriter fw;
    int run,wicket;
    double over;
    public CrickBuzzApp(String us)
    {
        this.user=us;
        try{
        this.fw=new FileWriter(user+".txt");
                    
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
            this.run=sr;
            this.wicket=sw;
            this.over=so;
            this.currentrunraate=sr/so;
            this.reqrunraate=(fr-sr)/(fo-so);
            this.predictedscore=(int)this.currentrunraate*20;
        }
        else
        {
             this.run=fr;
             this.wicket=fw;
             this.over=fo;
             this.currentrunraate=fr/fo;
             this.predictedscore=(int)this.currentrunraate*20;
             this.reqrunraate=0.0;
        }
        display();
        writeToFile();
        
    }
    public void display()
    {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("CRICKBUZZ APP");
        System.out.println("USER WATCHING:"+this.user);
        System.out.println("CURRENT SCORE IS");
        System.out.println("RUN:"+this.run+" WICKETS:"+this.wicket+" OVERS:"+this.over);
        System.out.println("CURRENT RUN RATE:"+this.currentrunraate+" PREDICTED SCORE:"+this.predictedscore+" REQUIRED RUN RATE:"+this.reqrunraate);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        
    }
    public void writeToFile()
    {
        try
        {
            fw.close();
            this.fw=new FileWriter(this.user+".txt",true);
            this.fw.write("-----------------------------------------------------------------------------------------------------------------------\n");
            this.fw.append("CRICKBUZZ APP\n");
            this.fw.append("USER WATCHING:"+this.user+"\n");
            this.fw.append("CURRENT SCORE IS\n");
            this.fw.append("RUN:"+this.run+" WICKETS:"+this.wicket+" OVERS:"+this.over+"\n");
            this.fw.append("CURRENT RUN RATE:"+this.currentrunraate+" PREDICTED SCORE:"+this.predictedscore+" REQUIRED RUN RATE:"+this.reqrunraate+"\n");
            this.fw.append("-----------------------------------------------------------------------------------------------------------------------\n");
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
