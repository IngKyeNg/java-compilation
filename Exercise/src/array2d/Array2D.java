package array2d;

import java.util.Scanner;
import myEnum.Month;

class Day{
    
}
public class Array2D {
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Year>>");
      int sYear = Integer.parseInt(sc.nextLine());
      Day[][] Calendar = new Day[12][];
      for(Month m:Month.values()){
          Calendar[m.ordinal()] = new Day[m.NoOfDay(sYear)];
      }
      for(Month m:Month.values()){
          System.out.print(m+":");
          for(Day d:Calendar[m.ordinal()]) System.out.print("D");
          System.out.println();
      }
    }
}
