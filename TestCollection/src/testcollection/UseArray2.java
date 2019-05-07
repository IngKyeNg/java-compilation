package testcollection;
import java.util.Scanner;

public class UseArray2 {
  private final static int SZ=3;
  public static void main(String[] args){
    int n=0;
    Scanner sc = new Scanner(System.in);
    String[] items=new String[SZ];
    while(true){
      if(n==items.length){//Array full. Need to swap to longer one
        String[] buf=new String[n+SZ];
        for(int i=0;i<n;i++) buf[i] = items[i];
        items = buf;
      }      
      System.out.print("item["+n+"]>>");
      String s = sc.nextLine().trim();
      if(s.length()==0) break;
      items[n++] = s;
    }
    System.out.println("==== The items you keyed in =====");
    for(int i=0;i<n;i++) System.out.println(items[i]);
  }  
}
