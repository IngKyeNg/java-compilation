package bitwiseoperator;

public class BitwiseOperator2 {
  static void ShowBits(int bits){
    for(int i=0;i<32;i++){
      System.out.print((bits&0x80000000)==0?"0":"1");
      bits <<= 1;
    }
    System.out.println();
  }
  
  //static final int HAS_CONDO=0b00000000_00000000_00000000_00010000;
  static final int HAS_CAR=    0x00000001;
  static final int HAS_CASH=   0x00000002;
  static final int HAS_CAREER= 0x00000004;
  static final int HAS_CERT=   0x00000008;
  static final int HAS_CONDO=  0x00000010;
  public static void main(String[] args) {
    int status = HAS_CAREER | HAS_CASH;
    ShowBits(status);
    System.out.println("After add in HAS_CAR");
    status |= HAS_CAR;
    ShowBits(status);
    System.out.println("Now I m jobless");
    status &= ~HAS_CAREER;
    ShowBits(status);
    System.out.println("Toggeling status HAS_CARRER and HAS_CASH");
    status ^= (HAS_CAREER | HAS_CASH);
    ShowBits(status);
    System.out.println(((status&HAS_CAREER)!=0)?"Has carreer":"No carreer");
    System.out.println(((status&HAS_CASH)!=0)?"Has cash":"No cash");
    //status &= ~HAS_CAREER;
    System.out.println(((status&(HAS_CAR|HAS_CAREER))==(HAS_CAR|HAS_CAREER))?
        "Has Both Car and Career":"Not OK");
  }
}
