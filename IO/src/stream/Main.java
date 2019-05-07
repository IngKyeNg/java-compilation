package stream;

import java.io.*;

public class Main {

  public static void main(String[] args) {
    try {
      FileReader input = new FileReader("In.txt");
      try {
        FileWriter output = new FileWriter("Out.txt");
        try {
          while (true) {
            char[] buffer = new char[128];
            int charsRead;
            if ((charsRead = input.read(buffer)) == -1) {
              break;
            }
            output.write(buffer, 0, charsRead);
          }
        } finally {
          output.close();
        }
      } finally {
        input.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
