/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressresolutionprotocol;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */

public class AdressResolutionProtocolClient {
    
    private static Scanner sc=new Scanner(System.in);
    
    public static void main(String args[])throws Exception
    {
    
        Socket s=new Socket("localhost",1235);
        System.out.println("enter the IP address:");
        String str=sc.next();
        
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
        dos.writeUTF(str);
        System.out.println("request send to the server");
         
        String r=dis.readUTF()+"";
        System.out.println("Response from the server");
        System.out.println("Internet Address        Physical Address       Type");
        System.out.println(r);
    }
}
