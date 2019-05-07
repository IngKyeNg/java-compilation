package generic;
import java.util.*;

public class GenericMethod {

  static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
    for (T o : a) c.add(o);
  }
  public static void main(String[] args) {
    System.out.println("------Integer Items-----");
    Integer[] idata = {1, 2, 3, 4};
    ArrayList<Integer> iitems = new ArrayList<>();
    fromArrayToCollection(idata, iitems);
    for (Integer item : iitems) {
      System.out.println(item);
    }
    System.out.println("------Double Items-----");
    Double[] ddata = {1.0, 2.0, 3.0, 4.0};
    ArrayList<Double> ditems = new ArrayList<>();
    fromArrayToCollection(ddata, ditems);
    for (Double item : ditems) {
      System.out.println(item);
    }
  }
}
