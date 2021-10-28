package singleton;

// 不仅可以解决线程同步，还可以防止反序列化（因为枚举类没有构造方法）
public enum Single05 {
  instance;
}
