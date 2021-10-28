public class staticProxy {

    static interface Interface {
        void sayHi();
    }

    static class Proxy implements Interface {

        private Interface anInterface;

        public Proxy(Interface anInterface) {
            this.anInterface = anInterface;
        }

        @Override
        public void sayHi() {
            anInterface.sayHi();;
        }
    }

    // 使用方式一
    static class BeProxy implements Interface {
        @Override
        public void sayHi() {

        }
    }

  // 使用方式二
  public static void main(String[] args) {
    new Proxy(() -> {});
    new Proxy(new Interface() {
        @Override
        public void sayHi() {

        }
    });
  }
}
