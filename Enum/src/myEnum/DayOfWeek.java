package myEnum;
//public enum DayOfWeek{SUN, MON, TUE, WED, THU, FRI, SAT}

public enum DayOfWeek{
  SUN("Sunday"), 
  MON("Monday"), 
  TUE("Tuesday"), 
  WED("Wednesday"), 
  THU("Thursday"), 
  FRI("Friday"), 
  SAT("Saturday");
  public final String FullName;
  private DayOfWeek(String nm){
    FullName = nm;
  }
}

