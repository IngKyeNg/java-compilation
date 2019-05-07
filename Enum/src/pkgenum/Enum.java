package pkgenum;
//enum is a set concept
//enum gives better symantics
import myEnum.*;

public class Enum {
  public static void main(String[] args) {
    Month m = Month.FEB;
    
    System.out.println("m:"+m);
    System.out.println("m.ordinal():"+m.ordinal());
    System.out.println("m.FullName:"+m.FullName);
    System.out.println("m.NoOfDay():"+m.NoOfDay());
    System.out.println("m.NoOfDay(2015):"+m.NoOfDay(2016));
  }
}
