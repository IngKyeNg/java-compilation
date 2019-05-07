package fileio;

import java.io.*;

public class Main {

  public static void main(String[] args) {
    File f = null;
    try {
      f = new File("In.txt");
      BufferedReader in = new BufferedReader(new FileReader(f));
      try {
        String s = in.readLine();
        while (s != null) {
          System.out.println("read: " + s);
          s = in.readLine();
        }
      } finally {
        in.close();
      }
    } catch (FileNotFoundException ex) {
      System.err.println("file not found " + f);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
