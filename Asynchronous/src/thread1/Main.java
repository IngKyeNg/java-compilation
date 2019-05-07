package thread1;

public class Main implements Runnable {

  static long n = 0;

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      n = n + 1;
      System.out.printf("Thread #%d:%d%n",
        Thread.currentThread().getId(), n);
    }
    System.out.printf("Thread #%d Ended%n",
      Thread.currentThread().getId());
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new Main());
    Thread t2 = new Thread(new Main());
    t1.start();
    t2.start();
    System.out.println("n="+n);
    System.out.println("main() ended...");
  }
}
