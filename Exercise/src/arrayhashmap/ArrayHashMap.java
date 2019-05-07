package arrayhashmap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ArrayHashMap {
    static HashMap<Character, Integer> hm = new HashMap<>();
    static void AddItem(char s) {
        hm.put(s, hm.containsKey(s)?(hm.get(s) + 1):1);
    }
    static boolean RemoveItem(char s) {
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
        Set<Character> ss = hm.keySet();
        for (Character s : ss) System.out.printf("%-15s%d%n", s, hm.get(s));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence>>");
        String inputStr = sc.nextLine();

        //char [] charArr = new  char[inputStr.length()];

        for(int n=0; n<inputStr.length();n++){
            char charArr = inputStr.charAt(n);
            AddItem(charArr);
        }
        ShowItems();
    }
    
}

