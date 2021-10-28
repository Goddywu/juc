package multi;

public class demo2 {

    static class Producer implements Runnable {
        private Book book;

        public Producer(Book book) {
            this.book = book;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                book.produce(i % 2 == 0 ? "oh" : "ji");
            }
        }
    }

    static class Consumer implements Runnable {
        private Book book;

        public Consumer(Book book) {
            this.book = book;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                book.consume();
            }
        }
    }

    static class Book {
        public String name;
        public boolean hasLeft = false;

        public synchronized void consume() {
            if (!hasLeft) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费了 " + name);
            hasLeft = false;
            notify();
        }

        public synchronized void produce(String name) {
            if (hasLeft) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.name = name;
            System.out.println("生产了 " + name);
            hasLeft = true;
            notify();
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        Thread pro = new Thread(new Producer(book), "生产者");
        Thread con = new Thread(new Consumer(book), "消费者");
        pro.start();
        con.start();
    }
}
