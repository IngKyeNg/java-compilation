package lambda;

public class FunctionalInterface1 {
    public static void main (String[] args){
        Thread t1 = new Thread(new Runnable(){
            @Override public void run() {
                System.out.println("Hi, I am running in a child thread");
            }
        });
        t1.start();
        try{
            t1.join();
        }
        catch(InterruptedException e) {
        }
        
        System.out.println("Main ended.");
             
    }
    
}
