package nativetypes;

public class NativeTypes {
  public static void main(String[] args) {
    int i = 10;
    long l = 100;
    byte b = 5; //-128..127
    short s = 10;
    
    int x = 22;
    int y = 7;
    
    double d = (double)x / y;
    float f = (float)x / y;
    
    boolean tf = false;    
    
    char c = 'A';
    c++;
    System.out.println("character c is " + c);    
    
    boolean result = 'A'>'a';
    System.out.println("result is " + result);    
    
    System.out.println("d is " + d);    
    System.out.println("f is " + f);    
    System.out.println("Value for A is " +(int)'A');
    System.out.println("Value for a is " +(int)'a');
    System.out.println("Char with value 68 is " +(char)68);
    System.out.println("Value for 学 is " +(int)'学');
    System.out.println("Value for 26657 is " +(char)26657);
    System.out.println("School in Japanese is \u5B66\u6821");
  } 
}
