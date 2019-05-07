package teststring;
class X{
  String Name;
  public X(String name){
    Name = name;
  }
  @Override
  protected void finalize() throws Throwable{
    System.out.println(Name+" is destroyed");
    super.finalize();
    new X(Name+"*");//Immediately become garbage
  }
}

public class TestString2 {
  public static void main2(String[] args) {
    new X("Foo");//Immediately become garbage
    String s="";
    System.out.println("Start the opration");
    for(int i=0;i<5000;i++) s = s + i;
    System.out.println("opration ended");
    System.out.println(s.length());
    System.out.println(s);
  }
  public static void main(String[] args) {
    new X("Foo");//Immediately become garbage
    StringBuilder s=new StringBuilder("");
    System.out.println("Start the opration");
    for(int i=0;i<5000;i++) s.append(i);
    System.out.println("opration ended");
    String s2 = s.toString();
    System.out.println(s2.length());
    System.out.println(s2);
  }
}
