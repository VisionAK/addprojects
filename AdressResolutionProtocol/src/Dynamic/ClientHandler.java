/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dynamic;
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 
/**
 *
 * @author ADMIN
 */
class ClientHandler extends Thread  
{ 
//  
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    private static Scanner sc=new Scanner(System.in);
    String str="";
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos,String st)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
        this.str=st;
    } 
  
    @Override
    public void run()  
    { 
        String received; 
        String toreturn; 
        
        while (true)  
        { 
            try { 
  
               
               
                 
                dos.writeUTF(str); 
                  
             
                received = dis.readUTF(); 
                  
                if(received!=null) 
                {  
                    System.out.println("Client " + this.s + " sends exit...");
                     System.out.println("Coressponding mac address: "+received);
                    System.out.println("Closing this connection."); 
                    
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
              

            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 