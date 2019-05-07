package autocloseable;
class X implements AutoCloseable{
  @Override
  public void close(){
    System.out.println("Release resources");
  }
}

public class AutoCloseableClass {
  public static void main(String[] args) throws Exception {
    System.out.println("Before enter to try-catch block");
    try(X x=new X()){
      System.out.println("In the try block");
      throw new Exception();
    }
    catch(Exception ex){
      System.out.println("Handle the exception");
      throw ex;
    }
    //System.out.println("After leaving try-catch block");
  }
  
}
