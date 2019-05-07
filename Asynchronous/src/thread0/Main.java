package thread0;

public class Main implements Runnable {
//    static long n = 0;

  static Long n = new Long(0);
//    synchronized void increaseN(){
//    	n = n + 1;
//    }

  @Override
  public void run() {
    for (int i = 0; i < 50000; i++) {
      synchronized (n) {
        n = n + 1;
      }
      //increaseN();
      System.out.printf("Thread #%d:%d%n", Thread.currentThread().getId(), n);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//            }
      //Thread.yield();
    }
    System.out.printf("Thread #%d Ended%n", Thread.currentThread().getId());
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new Main());
    Thread t2 = new Thread(new Main());
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
      System.out.println("Thread ended completely");
    } catch (InterruptedException e) {
      System.out.println("Continue before thread ended completely");
    }
    System.out.println("n="+n);
    System.out.println("main() ended...");
  }
}
