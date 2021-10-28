package singleton;

// double check lock   dcl
public class Single03 {

  private static Single03 instance;

  private Single03() {
  }

  public static Single03 getInstance() {
    if (instance == null) {
      synchronized (Single03.class) {
        if (instance == null) {
          instance = new Single03();
        }
      }
    }
    return instance;
  }
}
