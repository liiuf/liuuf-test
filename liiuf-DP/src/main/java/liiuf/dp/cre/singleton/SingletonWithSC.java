package liiuf.dp.cre.singleton;

/**
 * 饿汉式
 *
 * 优点：
 * - 在类装载的时候就完成实例化。
 * - 避免了线程同步问题。
 * 缺点：
 * - 在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * - 这种方式基于ClassLoader机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法，
 * 但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance就没有达到lazy loading的效果。
 */
public class SingletonWithSC {
    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithSC() {}

    private final static SingletonWithSC instance = new SingletonWithSC();

    public static SingletonWithSC getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonWithSC si = SingletonWithSC.getInstance();
        SingletonWithSC si2 = SingletonWithSC.getInstance();
        System.out.println(si.equals(si2));
    }
}