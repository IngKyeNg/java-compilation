package lambda;

public class Lambda1 {
  interface Names {
    void sayName(String name);
  }  
  
  public static void main(String[] args) {
    Names nameInstance = new Names() {
      @Override
      public void sayName(String name) {
        System.out.println("My Name is " + name);
      }
    };
    myName(nameInstance, "John");
  }

  private static void myName(Names nameInstance, String name) {
    nameInstance.sayName(name);
  }
}
