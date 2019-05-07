package bufferstream;

import java.io.*;

public class Main {

  public static void main(String[] args) {
    try {
      FileReader input = new FileReader("In.txt");
      BufferedReader bufferInput = new BufferedReader(input);
      try {
        FileWriter output = new FileWriter("Out.txt");
        BufferedWriter bufferOutput = new BufferedWriter(output);

        try {
          while (true) {
            String line;
            if ((line = bufferInput.readLine()) == null) {
              break;
            }
            bufferOutput.write(line, 0, line.length());
            bufferOutput.newLine();
          }
        } finally {
          bufferOutput.close();
          output.close();
        }
      } finally {
        bufferInput.close();
        input.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
