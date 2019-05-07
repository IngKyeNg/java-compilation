package defaultmethod;

public class DefaultMethod implements MyInterface {

  public static void main(String[] args) {
    System.out.println("I am OK");
    
  }
  
  @Override
  public void sayHi() {
      System.out.println("I am from the main.");
  }

  @Override
  public void saySomething() {
    System.out.println("Hello World");
  }

}
