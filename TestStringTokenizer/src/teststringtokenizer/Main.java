package teststringtokenizer;

import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args){
     String s="Java Programming is Fun!";
     System.out.println("-------Using Tokenizer-------");
     StringTokenizer st = new StringTokenizer(s);
     while(st.hasMoreElements()){
       System.out.println(st.nextToken());
     }
     System.out.println("\n-------Using split()-------");
     String[] ss = s.split(" ");
     for(String item:ss) System.out.println(item);
   }
}