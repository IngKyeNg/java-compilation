package thread5;

public class Main implements Runnable {

  static long n = 0;

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      n = n + 1;
      //System.out.printf("Thread #%d:%d%n", Thread.currentThread().getId(), n);
    }
    //System.out.printf("Thread #%d Ended%n", Thread.currentThread().getId());
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
    System.out.println("n=" + n);
    System.out.println("main() ended...");
  }
}
