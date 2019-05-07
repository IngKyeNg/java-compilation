package testboxing;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    int n = 100;
    Integer pInt = new Integer(n); //Boxing
    Integer pInt2 = n; //Autoboxing
    int m = pInt;   //Autounboxing
    System.out.println("pInt=" + pInt);
    System.out.println("n=" + n);
    System.out.println("pInt=" + pInt);
    System.out.println("pInt2=" + pInt2);
    System.out.println("m=" + m);
    
    ArrayList data1 = new ArrayList();//Raw type
    data1.add(100);
    int d1 = (Integer)data1.get(0);//Casting is required

    ArrayList<Integer> data2 = new ArrayList<>();//Integer type
    data2.add(100);
    int d2 = data2.get(0);//No casting is needed.
  }
}
