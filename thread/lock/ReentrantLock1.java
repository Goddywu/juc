package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

  // 是否为公平锁
  Lock lock = new ReentrantLock(true);

  void test1() {
    for (int i = 0; i < 100; i++) {
      try {
        lock.lock();
        System.out.println("1111");
      } finally {
        lock.unlock();
      }
    }
  }

  void test2() {
    for (int i = 0; i < 100; i++) {
      try {
        lock.lock();
        System.out.println("2222");
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    ReentrantLock1 r = new ReentrantLock1();
    new Thread(r::test1).start();
    new Thread(r::test2).start();
  }
}
