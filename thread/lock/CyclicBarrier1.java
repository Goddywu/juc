package lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier1 {

  public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(10, () -> {
      System.out.println("------满了-----");
    });
    for (int i = 0; i < 100; i++) {
      new Thread(() -> {
        try {
          System.out.println(Thread.currentThread().getName());
          barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
          e.printStackTrace();
        }
      }).start();
    }
  }

}
