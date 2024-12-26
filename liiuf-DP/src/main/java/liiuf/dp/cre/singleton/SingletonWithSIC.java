package liiuf.dp.cre.singleton;

/**
 * 这种方式采用了类装载的机制来保证初始化实例时只有------一个线程。
 * 静态内部类万式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，
 * 从而完成Singleton的实例化。
 *
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *
 * 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 *
 * 结论：推荐使用
 */
public class SingletonWithSIC {
    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithSIC() {}

    private static class SingletonInstance {
        private static final SingletonWithSIC instance = new SingletonWithSIC();
    }

    /**
     * 说明：
     *  JVM 在装载类时，是线程安全的
     *  在装载 Singleton 时，不会同时装载 SingletonInstance
     */
    public static SingletonWithSIC getInstance() {
        return SingletonInstance.instance;
    }
}
