package exceptionhandling;

public class ExceptionHandling4 {
  static class ResourceHungry implements AutoCloseable{
    public ResourceHungry(){
      System.out.println("Allocate heavy resources");
    }
  
    public void PerformJob(){
      System.out.println("Do job by using the resources");
    }
    
    @Override
    public void close() {
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
    try(ResourceHungry rh = new ResourceHungry()){
      rh.PerformJob();
    }
    catch(Exception ex){
      
    }
      
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
