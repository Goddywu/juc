package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock1 {
  static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  static Lock read = lock.readLock();
  static Lock write = lock.writeLock();

  public static void main(String[] args) {

  }
}
