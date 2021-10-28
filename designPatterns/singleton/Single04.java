package singleton;

// 静态内部类，刚加载类的时候不加载静态内部类，类加载器只加载一次
public class Single04 {

  private Single04() {
  }

  private static class Single04Holder {

    private final static Single04 instance = new Single04();
  }

  public static Single04 getInstance() {
    return Single04Holder.instance;
  }
}
