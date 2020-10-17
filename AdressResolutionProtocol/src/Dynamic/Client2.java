/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Client2 {
    private static Scanner sc=new Scanner(System.in);
    private static String ip="224.0.0.22";
    private static String mac="01-00-5e-00-00-16";
    public static void main(String args[])throws Exception
    {
    
       
         System.out.println("client 2 is runnning");
        Socket s=new Socket("localhost",1235);
         System.out.println("Connected to server");
        
        
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
        
        
         while (true)  
            { 
                
                
                 
                 String r=dis.readUTF()+"";
                System.out.println("client 2 recieved message "+r);
                if(r.equalsIgnoreCase(ip))
                {
                    System.out.println("ipAddress Macthed");
                    dos.writeUTF(mac+"");
                    System.out.println("coressponding mac address send");
                    
                } 
               
               
            } 
        
        
        
        
        
    }
}
