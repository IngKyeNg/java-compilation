package exercises;

import java.io.*;
import java.util.ArrayList;

public class ex01 {

  public static void main(String[] args) {
    File f = new File("Data.txt");
    try {
      BufferedReader in = new BufferedReader(new FileReader(f));
      try {
        ArrayList<Double> data = new ArrayList<>();
        String s = in.readLine();
        while (s != null) {
          try{
            double d = Double.parseDouble(s);
            data.add(d);
          }
          catch(Exception ex){
            //Ignore non well-formed data
          }
          s = in.readLine();
        }
        if(data.size()>0){
          double sum=0;
          double min=data.get(0);
          double max=min;
          for(double d:data){
            sum += d;
            if(min>d) min = d;
            if (max<d) max = d;
          }
          double average = sum/data.size();
        
          System.out.printf("Sum is %.2f%n",sum);
          System.out.printf("Min is %.2f%n",min);
          System.out.printf("Max is %.2f%n",max);
          System.out.printf("Average is %.2f%n",average);
        }
        else System.out.println("No number found in the file!");
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
