package multi;

public class sleep {
    static class MyRunnable implements Runnable {
        private int ticket = 5;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName()
                        + " 正在出售 " + (ticket--) + " 张票");
                //                    Thread.sleep(10);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new impl.MyRunnable();
        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");
        Thread t3 = new Thread(r, "线程3");
        t1.start();
        t1.setPriority(10);
        t2.start();
        t3.start();
    }
}
