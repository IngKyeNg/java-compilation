package testgc;

class MyClass {
  public MyClass() {
    System.out.println("In the Constructor");
  }
  @Override protected void finalize() {
    System.out.println("In the Destructor");
    try {
      super.finalize();
    } catch (Throwable t) {
      //Handle the t here
    }
  }
}

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Before the object creation");
    MyClass myObj = new MyClass();
    System.out.println("After the object is created");
    myObj = null;
    System.out.println("After the object became Garbage");
    System.gc();//Careful! This is asynchronous call
    Thread.sleep(1000);//Give enough time for GC to start
    System.out.println("After the GC reclaim the object");
    System.out.println("Ending the program");
  }
}
