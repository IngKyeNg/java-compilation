package pscanner;

import java.net.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class PScanner implements Runnable{
    
    static int NPorts=0;
    int Start;
    int End;
    String Host;
    PScanner(String host, int start, int end) {
      Start = start;
      End = (end>65535?65535:end);
      Host = host;
    }
    
    @Override
    public void run() {
        for (int n =0; n<65536; n++){
            for (int i = Start; i <=End; i++) {
            Socket connection = null;
            try {
            connection = new Socket(Host, i);
            System.out.println("There is a server on port "
                        + i + " of " + Host);
            synchronized(PScanner.class){
                NPorts++;
            }  
            } catch (IOException ex) {
                // must not be a server on this port
            } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException ex) {
            }
            }
            } // end for
        }
    }
    
    public static void main(String[] args) {
        
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Host[localhost]>>");
        String host = sc.nextLine().trim();
        if (host.equals("")) host ="localhost";
        
        InetAddress ia=null;
            try {
            
            host=JOptionPane.showInputDialog("Enter the Host name to scan:\n example: xxx.com");
                if(host!=null){
                ia = InetAddress.getByName(host);
            scan(ia); }
        }
            catch (UnknownHostException e) {
            System.err.println(e );
        }
        System.out.println("Bye from NFS");
        //System.exit(0);
    }
    
        public static void scan(final InetAddress remote) {
        //variables for menu bar
        
        int port=0;
        String hostname = remote.getHostName();
        
        for ( port = 0; port < 65536; port++) {
            try {
            Socket s = new Socket(remote,port);
            System.out.println("Server is listening on port " + port+ " of " + hostname);
            s.close();
        }
            catch (IOException ex) {
            // The remote host is not listening on this port
            System.out.println("Server is not listening on port " + port+ " of " + hostname);
        }
        }//for ends
   }
}

