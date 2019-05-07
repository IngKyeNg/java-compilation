package adt;

public class ADT {//Abstract Data Type
 public static void main(String[] args) {
    Matrix mA = new Matrix(3,2,
        1,2,
        3,4,
        5,6
    );
    Matrix mB = new Matrix(3,2,
        3,1,
        5,7,
        8,2
    );
    Matrix mC = new Matrix(3,3,
        2,0,1,
        5,6,8,
        9,4,3
    );
    try{
      ((mA.Multiply(mB.Transpose())).Add(mC)).Show();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}
