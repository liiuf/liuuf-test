package liiuf.dp.stru.proxy.ja;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过接口进行代理，需要目标类实现接口。
 */
public class ProxyFactory {
    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DefinedHandler(target));
    }

    // 静态方法，需要 new 静态内部类
    private static class DefinedHandler<T> implements InvocationHandler {
        private T target;

        DefinedHandler(T target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 扩展功能
            System.out.println("代理扩展了===");
            return method.invoke(target, args);
        }
    }
}