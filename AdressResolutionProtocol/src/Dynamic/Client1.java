/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Client1 {
    private static Scanner sc=new Scanner(System.in);
    private static String ip="192.168.43.255";
    private static String mac="ff-ff-ff-ff-ff-ff";
    public static void main(String args[])throws Exception
    {
    
        System.out.println("client 1 is runnning");
        Socket s=new Socket("localhost",1235);
        System.out.println("Connected to server");
        
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
        
        
//      
        
          while (true)  
            { 
                
                
                 
                 String r=dis.readUTF()+"";
                System.out.println("client 1 recieved message "+r);
                if(r.equalsIgnoreCase(ip))
                {
                    System.out.println("ipAddress Macthed");
                    dos.writeUTF(mac+"");
                    System.out.println("coressponding mac address send");
                    
                } 
                 
               
            } 
        
        
    }
}
