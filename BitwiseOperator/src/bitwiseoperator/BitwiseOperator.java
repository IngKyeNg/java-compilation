package bitwiseoperator;

public class BitwiseOperator {
  static void ShowBits(int bits){
    for(int i=0;i<32;i++){
      System.out.print((bits&0x80000000)==0?"0":"1");
      bits <<= 1;
    }
    System.out.println();
  }
  public static void main(String[] args) {
    int x=3,y=5;
    System.out.print("x:\t");   ShowBits(x);
    //System.out.print("y:\t");   ShowBits(y);
    System.out.print("x&y:\t"); ShowBits(x&y);
    //System.out.print("x|y:\t"); ShowBits(x|y);
    //System.out.print("x^y:\t"); ShowBits(x^y);
    //System.out.print("x>>1:\t"); ShowBits(x>>1);
    //System.out.print("x<<1:\t"); ShowBits(x<<1);
    //System.out.print("~x:\t"); ShowBits(~x);
  }
}



















/*

*/
