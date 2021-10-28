import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class jdkProxy {
    static interface Calculator {
        public int add(int a, int b);
    }

    static class MyCalculator implements Calculator {

        @Override
        public int add(int a, int b) {
            return a + b;
        }
    }

    static class CalculatorProxy {

        public static Calculator getProxy(final Calculator calculator) {
            // 获取类加载器
            ClassLoader loader = calculator.getClass().getClassLoader();
            // 获取要实现的接口
            Class<?>[] interfaces = calculator.getClass().getInterfaces();

            InvocationHandler handler = (proxy, method, args) -> {
                // 自定义操作
                Object result = method.invoke(calculator, args);
                // 自定义操作
                return result;
            };

            return (Calculator) Proxy.newProxyInstance(loader, interfaces, handler);
        }
    }

  public static void main(String[] args) {
    Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());

  }
}
