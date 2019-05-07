package Socket;

import java.net.*;
import java.io.*;

public class PortScanner2 {
  static int NPorts=0;
  static class Scanner extends Thread {
    int Start;
    int End;
    String Host;
    Scanner(String host, int start, int end) {
      Start = start;
      End = (end>65535?65535:end);
      Host = host;
    }
    @Override
    public void run() {
      for (int i = Start; i <=End; i++) {
        //System.out.println(i);
        Socket connection = null;
        try {
          connection = new Socket(Host, i);
          System.out.println("There is a server on port "
                        + i + " of " + Host);
          synchronized(PortScanner2.class){
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
    } // end try
  }
  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("Host[localhost]>>");
    String host = sc.nextLine().trim();
    if (host.equals("")) host ="localhost";
    try {
      final long startTime = System.currentTimeMillis();
      InetAddress theAddress = InetAddress.getByName(host);
      System.out.print("How Many Thread?>>");
      int NoOfThreads = Integer.parseInt(sc.nextLine());
      java.util.ArrayList<Thread> scanners = new java.util.ArrayList<>(NoOfThreads);
      int ThreadsPerScanner = 65535/(NoOfThreads-1);
      int Start=1;
      for(int i=0;i<NoOfThreads;i++){
        Scanner scanner = new Scanner(host,Start,Start+ThreadsPerScanner);
        Start += ThreadsPerScanner;
        scanners.add(scanner);
        scanner.start();
      }
      for(Thread scanner:scanners){
        try{
          scanner.join();
        }
        catch(Exception ex){
        }
      }
      final long endTime = System.currentTimeMillis();
      System.out.println("Total execution time: " + (endTime - startTime)/1000.0 + "Seconds" );  
    } // end try
    catch (UnknownHostException ex) {
      System.err.println(ex);
    }
    System.out.println("Scanning completed.");
      System.out.println("Found "+NPorts+" opend ports");
    }  // end main
}  // end PortScanner
