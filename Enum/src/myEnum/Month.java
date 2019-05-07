package myEnum;
import java.util.*;

public enum Month {
  JAN("January"),
  FEB("February"),
  MAR("March"),
  APR("April"),
  MAY("May"),
  JUN("June"),
  JUL("July"),
  AUG("August"),
  SEP("September"),
  OCT("October"),
  NOV("November"),
  DEC("December");
  public final String FullName;
  private Month(String name){
    FullName=name;
  }
  static private boolean isLeapYear(int year){
    if ((year%4)!=0) return false;
    if ((year%100)!=0) return true;
    if ((year%400)!=0) return false;
    return true;
  }
  public int NoOfDay(){
    return NoOfDay(Calendar.getInstance().get(Calendar.YEAR));
  }
  public int NoOfDay(int year){
    int n=31;
    switch(this){
        case FEB:
          n = isLeapYear(year)?29:28;
          break;
        case APR:
        case JUN:
        case SEP:
        case NOV:
          n = 30;
          break;
    }    
    return n;
  }
}