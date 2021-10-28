package lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
  private static void usingCountDownLatch() {
    Thread[] threads = new Thread[10];
    CountDownLatch latch = new CountDownLatch(threads.length);

    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(() -> {
        System.out.println(Thread.currentThread().getName());
        latch.countDown();
      });
    }

    for (int i = 0; i < threads.length; i++) {
      threads[i].start();
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 阻塞直到所有线程执行完毕
    System.out.println("所有线程执行完毕");

  }

  public static void main(String[] args) {
    usingCountDownLatch();
  }

}
