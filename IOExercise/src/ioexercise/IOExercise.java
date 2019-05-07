package ioexercise;

import java.io.*;
import java.util.*;

public class IOExercise {
    
    
  public static void main(String[] args) {
      ArrayList<Double> data = new ArrayList<>();
      try {
      FileReader input = new FileReader("Data.txt");
      BufferedReader bufferInput = new BufferedReader(input);
      try {
        while (true) {
          String line;
          if ((line = bufferInput.readLine()) == null) {
            break;
          }
          
          try{
            double each = Double.parseDouble(line);
            System.out.println("Integer."+each+" Store into array.");
            data.add(each);
          } 
          catch(NumberFormatException ex){
            System.out.println("Not integer. Skipped");
          }   
         }
      } finally {
        bufferInput.close();
        input.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
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

  }
}
