package pkgenum;
import myEnum.DayOfWeek;
import static myEnum.DayOfWeek.*;
//import static myEnum.WorkingDay.*;
import java.util.Scanner;
import myEnum.Month;

public class Enum2 {
    
    public static void main(String[] args) {
    
    while (true) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Month>>");
      String sMonth = sc.nextLine().trim().toUpperCase();
      System.out.print("Year>>");
      String sYear = sc.nextLine().trim();
      
      int currYear;
      if (sYear!=""){
          currYear = Integer.parseInt(sYear);
      }
      else currYear = 2017;
        
      if (sMonth.equals("")) break;
      try {
        Month m = Month.valueOf(sMonth);
        m = Month.valueOf(sMonth);
        int days;
        switch (m) {
          case JAN: days = m.NoOfDay(currYear);  break;
          case FEB: days = m.NoOfDay(currYear);   break;
          case MAR: days = m.NoOfDay(currYear);  break;
          case APR: days = m.NoOfDay(currYear);  break;
          case MAY: days = m.NoOfDay(currYear);   break;
          case JUN: days = m.NoOfDay(currYear);  break;
          case JUL: days = m.NoOfDay(currYear);  break;
          case AUG: days = m.NoOfDay(currYear);   break;
          case SEP: days = m.NoOfDay(currYear);  break;
          case OCT: days = m.NoOfDay(currYear);  break;
          case NOV: days = m.NoOfDay(currYear);   break;
          case DEC: days = m.NoOfDay(currYear);  break;
          default: days = m.NoOfDay(currYear);
        }
        System.out.println(m.FullName+" has "+days+" days.");
      } catch (Exception ex) {
        System.out.println("Invalid day:" + sMonth);
      }
    }
  }
    
  public static void main2(String[] args) {
    DayOfWeek day = THU;
    //DayOfWeek day = DayOfWeek.THU;
    System.out.println("day:" + day);
    System.out.println("day.ordinal():" + day.ordinal());
    System.out.println("day.toString():" + day.toString());
    System.out.println("day.FullName:" + day.FullName);
    while (true) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Day>>");
      String sDay = sc.nextLine().trim().toUpperCase();
      if (sDay.equals("")) break;
      try {
        day = DayOfWeek.valueOf(sDay);
        String food;
        switch (day) {
          case MON: food = "Noddle";  break;
          case TUE: food = "Satay";   break;
          case FRI: food = "BigMac";  break;
          default: food = "Chicken Rice";
        }
        System.out.println(day.FullName+" you should take "+food);
      } catch (Exception ex) {
        System.out.println("Invalid day:" + sDay);
      }
    }
  }
}