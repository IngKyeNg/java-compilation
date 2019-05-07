package exceptionhandling;

public class ExceptionHandling3 {
  static class ResourceHungry{
    public ResourceHungry(){
      System.out.println("Allocate heavy resources");
    }
  
    public void PerformJob(){
      System.out.println("Do job by using the resources");
    }
    
    public void ReleaseResources(){
      System.out.println("\nRelease allocated resources");
    }
  
    @Override
    protected void finalize(){
      System.out.println("\nCalling destructor");
      try{
        super.finalize();
      }catch(Throwable t){
      }    
    }
  }
  public static void main(String[] args) throws Exception{
    ResourceHungry rh = new ResourceHungry();
    rh.PerformJob();
    rh.ReleaseResources();
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
