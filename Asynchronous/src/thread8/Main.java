package thread8;

public class Main extends Thread {

  static long n = 0;

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      synchronized (Main.class) {
        n = n + 1;
      }
      //System.out.printf("Thread #%d:%d%n", Thread.currentThread().getId(), n);
    }
    //System.out.printf("Thread #%d Ended with n=%d%n", Thread.currentThread().getId(), n);
  }

  public static void main(String[] args) {
    Thread t1 = new Main();
    Thread t2 = new Main();
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
