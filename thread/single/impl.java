package single;

public class impl {
    static class MyRunnable implements Runnable {

        public MyRunnable(String name) {
            super();
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "   " + i);
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable("线程1");
        new Thread(r).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
    }
}
