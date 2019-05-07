package queens;

import java.io.*;

public class Queens {
    static int[] Qs = new int[8];
    static int NoOfAnswers=0;
    static int Row=0;
    
    static void Solve(){
        if(Row==8) {
            NoOfAnswers++;
            ShowAnswer();
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
    static void ShowAnswer(){
        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                System.out.print((Qs[r]==c)?"Q":",");
            }
            System.out.println();
        }
        System.out.println();
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
  
//    static long Fact(int n) {
//        assert(n>=0):"n cannot be negative!";
//        if(n<2) return 1;
//        return n * Fact(n-1);
//    }
    public static void main(String[] args) {

        Solve();
        System.out.println("No of Answers found is "+NoOfAnswers);
//        for(int n=0;n<=12;n++){
//               System.out.printf("%d!=>%d%n",n,Fact(n));
//        }
    }
    
}
