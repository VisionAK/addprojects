/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import java.util.*;
public abstract class IplMatch 
{
    protected String team1,team2,teamtobatfirst;
    
    protected int fruns,fwickets;
    protected double fovers;
    
    protected int sruns,swickets;
    protected double sovers;
    
    ArrayList<Observer> list;
    
    public void addObserver(Observer ob)
    {
        
    }
    public void removeObserver(Observer ob)
    {
        
    }
}
