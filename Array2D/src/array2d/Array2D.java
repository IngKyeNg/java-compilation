package array2d;

public class Array2D {
  public static void main(String[] args) {
    int[][] mA = {//int[][] mA = new int[][]{
      {1,2},      //  new int[]{1,2},
      {3,4},      //  new int[]{3,4},
      {5,6},      //  new int[]{5,6},
    };            //};
    int[][] mB = {
      {1,2},
      {3,4},
    };
    if(mA[0].length==mB.length){
      int[][] mC = new int[mA.length][mB[0].length];
      for(int r=0;r<mC.length;r++){
        for(int c=0;c<mC[0].length;c++){
          for(int i=0;i<mB.length;i++) mC[r][c] += mA[r][i]*mB[i][c];
        }
      }
      ShowMatrix(mA);
      System.out.println("\t    X");
      ShowMatrix(mB);
      System.out.println("\t    =");
      ShowMatrix(mC);
    }
    else System.out.println("Cannot multiply-lah!");    
  }
  static void ShowMatrix(int[][] m){
    for(int r=0;r<m.length;r++){
      for(int c=0;c<m[0].length;c++) System.out.print("\t"+m[r][c]);
      System.out.println();
    }
    System.out.println();
  }  
}
