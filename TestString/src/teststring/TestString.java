package teststring;

public class TestString {
//  static class X{
//    int Value;
//    public X(int v){
//      Value = v;
//    }
//    @Override
//    public boolean equals(Object rhs){
//      return Value==((X)rhs).Value;
//    }
//    @Override
//    public int hashCode() {
//      return Value;
//    }
//  }
  public static void main(String[] args) {
//    X x1 = new X(100);
//    X x2 = new X(100);
//    
//    System.out.println("x1==x2:" +(x1==x2));
//    System.out.println("x1.equals(x2):" + x1.equals(x2));
    
    
    String s1 = "AAA";
    String s2 = "AAA";
    String s3 = new String("AAA");
    System.out.println("s1==s2:"+(s1==s2)); //true
    System.out.println("s1.equals(s2):"+(s1.equals(s2))); //true
    System.out.println("s1==s3:"+(s1==s3)); //false
    System.out.println("s1.equals(s3):"+(s1.equals(s3))); //true
    s3 = s3.intern();
    System.out.println("s1==s3:"+(s1==s3)); //true
    System.out.println("s1.equals(s3):"+(s1.equals(s3))); //true
  }  
}
