package lock;

import java.util.concurrent.Semaphore;

public class Semaphore1 {

  public static void main(String[] args) {
    Semaphore s = new Semaphore(1);
    try {
      s.acquire();



      s.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
