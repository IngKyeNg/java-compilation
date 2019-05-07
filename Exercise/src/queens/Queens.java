package queens;

import java.io.*;

public class Queens {
    static int[] Qs = new int[8];
    static int NoOfAnswers=0;
    static int Row=0;
    
    static void Solve(){
        if(Row==8) {
            NoOfAnswers++;
            System.out.append(ShowAnswer());
            String result = ShowAnswer();
                  try {
        FileWriter output = new FileWriter("Result.txt");
        try {
            char[] buffer = new char[4000];
            for(int i=0;i<result.length();i++){
                char charsRead = result.charAt(i);
                output.write(buffer, i, charsRead);
            }
        } finally {
          output.close();
        }
    } catch (IOException e) {
      e.printStackTrace();
    }
        }
        else
        {
            for(int c=0;c<8;c++){
                if(IsValidColumn(c)){
                    Qs[Row] = c;
                    Row++;
                    Solve();    //Recursion
                    Row--;      //Backtracking
                }
            }
        }
    }
    static String ShowAnswer(){
        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                System.out.print((Qs[r]==c)?"Q":",");
                return (Qs[r]==c)?"Q":",";
            }
            System.out.println();
        }
        System.out.println();
        return null;
    }
    static boolean IsValidColumn(int c){
        for(int r=0;r<Row;r++){
            //Vertical Check
            if (Qs[r]==c) return false;
            
            //Diagonal Check
            int dRow = Row - r; //Always positive
            int dCol = c - Qs[r];
            if (dCol<0) dCol = - dCol;
            if(dCol==dRow) return false;
        }
        return true;
    }
  
    public static void main(String[] args) {

        Solve();
        System.out.println("No of Answers found is "+NoOfAnswers);
    }
    
}
