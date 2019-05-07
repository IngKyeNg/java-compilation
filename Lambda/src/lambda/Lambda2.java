package lambda;

public class Lambda2 {
  interface Names {
    public void sayName(String name);
  }  
  
  public static void main(String[] args) {
    myName(name->System.out.println("My name is " + name), "John");
  }

  private static void myName(Names nameInstance, String name) {
    nameInstance.sayName(name);
  }
}
