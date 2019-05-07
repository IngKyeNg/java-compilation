package methodreference;

import java.util.*;

public class MethodReference {

  public static void main(String args[]) {
    List names = new ArrayList();
    names.add("Banana");
    names.add("Papaya");
    names.add("Apple");
    names.add("Orange");
    names.add("Grape");
    
//    for(Object s:names){
//      System.out.println(s);
//    }

    names.forEach(System.out::println);
  }
}
