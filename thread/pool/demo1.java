package pool;

import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class demo1 {

  static class MyTask implements Runnable {
    private int num;

    public MyTask(int num) {
      this.num = num;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " " + num);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    //        ExecutorService es = Executors.newCachedThreadPool();
    //        ExecutorService es = Executors.newFixedThreadPool(3);
    //        ExecutorService es = Executors.newSingleThreadExecutor();
    //        for (int i = 0; i < 20; i++) {
    //            es.execute(new MyTask(i));
    //        }
    //        es.shutdown();

    ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
    for (int i = 0; i < 20; i++) {
                  es.schedule(new MyTask(i), 1, TimeUnit.SECONDS); // 延迟1秒执行
//      es.scheduleAtFixedRate(new MyTask(i), 0, 1, TimeUnit.SECONDS); // 每秒执行
//      es.scheduleWithFixedDelay(new MyTask(i), 0, 1, TimeUnit.SECONDS); // 每次执行后等1秒
    }
    TimeUnit.SECONDS.sleep(10);
    es.shutdown();
  }

}
