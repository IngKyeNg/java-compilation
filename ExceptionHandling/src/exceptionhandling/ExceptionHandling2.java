package exceptionhandling;

public class ExceptionHandling2 {
  static class ResourceHungry{
    public ResourceHungry(){
      System.out.println("Allocate heavy resources");
    }
  
    public void PerformJob(){
      System.out.println("Do job by using the resources");
    }
  
    @Override
    protected void finalize(){
      System.out.println("\nRelease allocated resources");
      try{
        super.finalize();
      }catch(Throwable t){
      }    
    }
  }
  public static void main(String[] args) throws Exception{
    ResourceHungry rh = new ResourceHungry();
    rh.PerformJob();
    rh = null;//Caused the object to be garbage
      
    //Simulate the delay
    System.out.print("Do somthing else:");
    for(int i=0;i<10;i++){
      System.out.print("*");
      Thread.sleep(2000);
    }
      
    System.gc();
    Thread.sleep(2000);//Give enough time for GC to start
    System.out.println("Bye...");
  }
}
