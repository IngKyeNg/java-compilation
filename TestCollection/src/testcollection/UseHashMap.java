package testcollection;
import java.util.*;

public class UseHashMap {
  static HashMap<String, Integer> hm = new HashMap<>();
  static void AddItem(String s) {
    hm.put(s, hm.containsKey(s)?(hm.get(s) + 1):1);
  }
  static boolean RemoveItem(String s) {
    if (hm.containsKey(s)) {
      int n = hm.get(s) - 1;
      if (n == 0) {
        hm.remove(s);
      } else {
        hm.put(s, n);
      }
      return true;
    }
    return false;
  }
  static void ShowItems() {
    Set<String> ss = hm.keySet();
    for (String s : ss) System.out.printf("%-15s%d%n", s, hm.get(s));
  }
  public static void main(String[] args) {
    AddItem("Apple");
    AddItem("Ciku");
    AddItem("Pisang");
    AddItem("Apple");
    AddItem("Apple");
    AddItem("Nenas");
    RemoveItem("Pisang");
    RemoveItem("Apple");

    ShowItems();
  }
}
