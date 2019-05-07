package defaultmethod;

public interface MyInterface {
  void saySomething(); 
  
  //void sayHi(); - only java 8
  default void sayHi() {
    System.out.println("Hi");
  }
}
