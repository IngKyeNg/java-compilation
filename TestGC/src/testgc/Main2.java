package testgc;

class X {
  public X() {
    System.out.println("Allocate resources at X level");
  }

  @Override  protected void finalize() throws Throwable {
    System.out.println("Deallocate resources at X level");
    super.finalize();
  }
}
class Y extends X {
  public Y() {
    System.out.println("Allocate resources at Y level");
  }
  
  @Override protected void finalize() throws Throwable{
    System.out.println("Deallocate resources at Y level");
    super.finalize();
  }
}

public class Main2 {
  public static void main(String[] args) throws Exception{
    X x = new Y();
    x = null;
    System.gc();//Careful! This is asynchronous call
    Thread.sleep(1000);//Give enough time for GC to start
    System.out.println("Program ended...");
  }
}
