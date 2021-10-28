package multi;

public class demo1 {
    static class MyRunnable implements Runnable {
        private int ticket = 20;

        @Override
        public void run() {
            while (ticket > 0) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                sale();
                Thread.yield();
            }
        }

        private synchronized void sale() {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " sell " + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");
        t1.start();
        t2.start();
    }
}
