package jaggedarray;

import java.util.Scanner;

enum Month{JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC};

class Day{
}

public class JaggedArray {
  static boolean isLeapYear(int year){
    if ((year%4)!=0) return false;
    if ((year%100)!=0) return true;
    if ((year%400)!=0) return false;
    return true;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Year>>");
    int year=Integer.parseInt(sc.nextLine());
    Day[][] Calender = new Day[12][];
    int n=0;
    for(Month m:Month.values()){
      switch(m){
        case APR:
        case JUN:
        case SEP:
        case NOV:
          n = 30;
          break;
        case FEB:
          n = isLeapYear(year)?29:28;
          break;
        default:
          n = 31;
      }
      Calender[m.ordinal()] = new Day[n];
    }
    for(Month m:Month.values()){
      System.out.print(m+": ");
      for(Day day:Calender[m.ordinal()]) System.out.print("D");
      System.out.println();
    }
    
    while(true){    
      System.out.print("Month Name>>");
      String sMonth = sc.nextLine().trim().toUpperCase();
      try{
        Month m = Month.valueOf(sMonth);
        System.out.printf("Month %s of %d has %d days%n",
            m,year,Calender[m.ordinal()].length);
        break;
      }
      catch(Exception ex){
        System.out.println("No such month!");
      }
      System.out.println("Try again!");
    }
  }
}
