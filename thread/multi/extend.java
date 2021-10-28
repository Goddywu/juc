package multi;

public class extend {
    static class MyThread extends Thread {
        private static int ticket = 5;

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName()
                        + " 正在出售 " + (ticket--) + " 张票");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread("线程1");
        Thread t2 = new MyThread("线程2");
        t1.start();
        t2.start();
    }
}
