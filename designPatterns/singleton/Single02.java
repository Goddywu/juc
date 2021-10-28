package singleton;

// 懒汉式 lazy loading 线程不安全
public class Single02 {

  private static Single02 instance;

  private Single02() {
  }

  private static Single02 getInstance() {
    if (instance == null) {
      instance = new Single02();
    }
    return instance;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      new Thread(() -> {
        System.out.println(Single02.getInstance().hashCode());
      }).start();
    }
  }
}
