package liiuf.dp.stru.proxy.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态生成被代理的子类，父类方法和类不能用final修饰
 */
public class CgProxyFactory implements MethodInterceptor {
    public Object getProxy(Object target) {
        // 增强器类，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类字节码对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        // 创建动态代理并返回
        return enhancer.create();
    }

    /**
     * @param o 代理对象
     * @param method 目标对象中的方法的Method实例
     * @param args 实际参数
     * @param methodProxy 代理类对象中的方法的Method实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("我被cglib代理了======");
        return methodProxy.invokeSuper(o, args);
    }
}