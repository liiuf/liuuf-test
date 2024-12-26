package liiuf.dp.cre.singleton;
/**
 * 饿汉式
 *
 * 和SingletonWithSC的静态常量实现类似。
 */
public class SingletonWithSB {
    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithSB() {}
    // 本类内部声明对象实例
    private final static SingletonWithSB instance;
    // 静态代码块中创建单例对象
    static {
        instance = new SingletonWithSB();
    }

    // 公有静态方法，返回对象实例
    public static SingletonWithSB getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonWithSB si = SingletonWithSB.getInstance();
        SingletonWithSB si2 = SingletonWithSB.getInstance();
        System.out.println(si.equals(si2));
    }
}