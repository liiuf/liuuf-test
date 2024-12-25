package liiuf.dp.cre.singleton;

/**
 * Double-Check概念 是多线程开发中常使用到的，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一-次，后面再次访问时，判断if (singleton == null)，直接return实例化对象，也避免的反复进行方法同步。
 * 线程安全，延迟加载，效率较高
 *
 * 总结：在实际开发中，推荐使用这种方式实现单例设计模式
 */
public class SingletonWithDoubleCheck {
    // 本类内部声明对象实例，使用volatile防止指令重排序，避免对象半实例化
    private static volatile SingletonWithDoubleCheck instance;

    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithDoubleCheck() {}

    // 静态公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
    public static synchronized SingletonWithDoubleCheck getInstance() {
        if(instance == null) {
            synchronized (SingletonWithDoubleCheck.class) {
                if(instance == null) {
                    instance = new SingletonWithDoubleCheck();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        SingletonWithDoubleCheck si = SingletonWithDoubleCheck.getInstance();
        SingletonWithDoubleCheck si2 = SingletonWithDoubleCheck.getInstance();
        System.out.println(si.equals(si2));
    }
}