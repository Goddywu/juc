package singleton;

// 饿汉式
public class Single01 {
    private static final Single01 instance = new Single01();

    // 确保其他类无法创建新实例
    private Single01() {};

    public static Single01 getInstance() {
        return instance;
    }

  public static void main(String[] args) {
    Single01 s1 = Single01.getInstance();
    Single01 s2 = Single01.getInstance();
    System.out.println(s1 == s2);
  }
}
