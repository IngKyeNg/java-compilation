package valvsrefeq;

class X {
  public int A;
  public X(int a) {
    A = a;
  }
  @Override
  public boolean equals(Object obj){
    X rhs = (X)obj;
    return this.A==rhs.A;
  }
}

public class ValVsRefEq {
  public static void main(String[] args) {
    X x1 = new X(100);
    X x2 = new X(100);
    System.out.println(x1==x2);
    System.out.println(x1.equals(x2));
    //x2 = x1;
    //System.out.println(x1==x2);
  }
}
