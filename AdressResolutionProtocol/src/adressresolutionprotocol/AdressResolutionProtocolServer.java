/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressresolutionprotocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.*;
import java.util.*;
public class AdressResolutionProtocolServer {

     private static final String Command = "arp -a";
    
     public static void getAdressResolutionProtocolTable(String cmd) throws Exception
     {  
          File fp = new File("AdressResolutionProtocolTable.txt");
          FileWriter fw = new FileWriter(fp);

          BufferedWriter bw = new BufferedWriter(fw);
         
          Process P = Runtime.getRuntime().exec(cmd);
          Scanner S = new Scanner(P.getInputStream()).useDelimiter("\\A");
          
          while(S.hasNext())
          {
              bw.write(S.next());
          }
              

          bw.close();
          fw.close();
     }
    
    



     public static String findMAC(String ip) throws Exception
     {
          File f = new File("AdressResolutionProtocolTable.txt");
          FileReader fr = new FileReader(f);
          BufferedReader br = new BufferedReader(fr);
          String ret="";
          String line=null;
         
          while ((line = br.readLine()) != null)
          {
               if (line.contains(ip))
              {
                   //System.out.println("Internet Address        Physical Address       Type");
                  // System.out.println(line);
                   ret=line;
                   // System.out.println(ret);
                   break;
              }
          }
          if((line == null))
          {
              //System.out.println("Unable to find MAC Address");
              
          }
              
              
         
          fr.close(); 
          br.close();  
          return(ret);
     }
    


     public static void main(String as[]) throws Exception
     {
          getAdressResolutionProtocolTable(Command);

          Scanner S = new Scanner(System.in);

          System.out.println("Simulation Of Adress Resolution Protocol");
          ServerSocket ss=new ServerSocket(1235);
          Socket s=ss.accept();
          DataInputStream dis=new DataInputStream(s.getInputStream());
          DataOutputStream dos=new DataOutputStream(s.getOutputStream());
          String str=dis.readUTF()+"";
          System.out.println("Rcieved IP Address: "+str);
          String IP = str;
          String r=findMAC(IP);
          
          System.out.println("Sending the Mac Address ");
          dos.writeUTF(r+"");
  
     }
    
}
