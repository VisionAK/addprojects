/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Server {
    private static Scanner sc=new Scanner(System.in);
    
    public static void main(String args[])throws Exception
    {
    
        ServerSocket ss=new ServerSocket(1235);
         

        System.out.println("enter the ip address:");
        String st=sc.next();
        System.out.println("broadcasting ip address");
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos,st); 
  
                // Invoking the start() method 
                t.start(); 
                  
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
       
            
       
        
      
        
        
        
    }
}
