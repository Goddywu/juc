package single;

public class extend {

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "   " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread("thread 1");
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
    }
}
