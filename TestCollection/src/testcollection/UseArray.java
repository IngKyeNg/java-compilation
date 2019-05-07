package testcollection;
import java.util.Scanner;

public class UseArray {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("How many items?>>");
    int n=Integer.parseInt(sc.nextLine());
    String[] items=new String[n];
    for(int i=0;i<n;i++){
      System.out.print("item["+i+"]>>");
      items[i] = sc.nextLine().trim();
    }
    System.out.println("==== The items you keyed in =====");
    for(String item:items) System.out.println(item);
  }  
}
