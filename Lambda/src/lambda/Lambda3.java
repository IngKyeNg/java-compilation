package lambda;

public class Lambda3 {
  interface MathOperation {
    int operation(int a, int b);
  }

  interface GreetingService {
    void sayMessage(String message);
  }

  public static void main(String args[]) {

    Lambda3 tester = new Lambda3();

    //with type declaration
    MathOperation addition = (int a, int b) -> a + b;

    //with out type declaration
    MathOperation subtraction = (a, b) -> a - b;

    //with return statement along with curly braces
    MathOperation multiplication = (int a, int b) -> {
      return a * b;
    };

    //without return statement and without curly braces
    MathOperation division = (int a, int b) -> a / b;

    System.out.println("10+5 = " + tester.operate(10, 5, addition));
    
    //Also can be like this....
    System.out.println("10+5 = " + tester.operate(10, 5, (a,b) -> a + b));
    
    
    
    System.out.println("10-C5 = " + tester.operate(10, 5, subtraction));
    System.out.println("10*5= " + tester.operate(10, 5, multiplication));
    System.out.println("10/5 = " + tester.operate(10, 5, division));

    //without parenthesis
    GreetingService greetService1 = 
        message -> System.out.println("Hello " + message);

    //with parenthesis
    GreetingService greetService2 = 
        (message)-> System.out.println("Hello " + message);

    greetService1.sayMessage("Mary");
    greetService2.sayMessage("Brown");
  }

  private int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }
}
