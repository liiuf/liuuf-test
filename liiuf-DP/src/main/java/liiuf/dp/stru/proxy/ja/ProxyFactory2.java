package liiuf.dp.stru.proxy.ja;

import java.lang.reflect.Proxy;

public class ProxyFactory2 {
    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            // 扩展功能
            System.out.println("代理扩展了===2");
            return method.invoke(target, args);
        });
    }
}