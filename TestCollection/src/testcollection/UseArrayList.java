package testcollection;
import java.util.*;

public class UseArrayList {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<String> items = new ArrayList<>(1000);
    int n =0;
    while(true){
      System.out.print("item["+n+"]>>");
      String s = sc.nextLine().trim();
      if(s.length()==0) break;
      items.add(s);
      n++;
    }
    //items.trimToSize();
    items.remove(1);
    items.add(0, "Dragon Fruit");
    System.out.println("==== The items you keyed in =====");
    for(String item:items) System.out.println(item);
    
    String firstItem = items.get(0);
    System.out.println("The first items is "+firstItem);
  }
}