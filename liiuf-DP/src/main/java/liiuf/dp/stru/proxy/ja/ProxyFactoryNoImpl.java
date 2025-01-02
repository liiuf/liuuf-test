package liiuf.dp.stru.proxy.ja;

import liiuf.dp.stru.proxy.ja.bean.ProxyNoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryNoImpl {
    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            // 没有实现接口，但方法相同
            ProxyNoService pos = new ProxyNoService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getDeclaringClass() != pos.getClass()) {
                            System.out.println("代理扩展了===");
                            Method realMethod = pos.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                            return realMethod.invoke(pos, args);
                        }

                        return method.invoke(pos, args);
                    }
                }
        );
    }
}