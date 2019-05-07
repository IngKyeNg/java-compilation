package testgc;

class Z {
  String Name;
  Z Sibling;

  public Z(String name) {
    Name = name;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println(Name + " is destroyed!");
    super.finalize();
  }
}

public class Island {

  public static void main(String[] args) throws Exception{
    Z a = new Z("A");
    Z b = new Z("B");
    Z c = new Z("C");
    a.Sibling = b;
    b.Sibling = c;
    c.Sibling = a;
    a = null;
    //b = null;
    c = null;
    //At this point the Island formed!
    new Z("D");//Immediately become garbage
    System.gc();
    Thread.sleep(1000);
    System.out.println("Program ended...");
  }
}
