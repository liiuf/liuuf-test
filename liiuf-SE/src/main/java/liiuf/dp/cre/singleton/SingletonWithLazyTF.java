package liiuf.dp.cre.singleton;

/**
 * 懒汉式
 *
 * 解决了线程不安全问题
 * 效率太低，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，
 * 后面的想获得该类实例，直接return就行了。方法进行同步效率太低
 *
 * 结论：在实际开发中，不推荐使用这种方式
 */
public class SingletonWithLazyTF {
    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithLazyTF(){}

    // 本类内部声明对象实例
    private static SingletonWithLazyTF instance;

    // 公有静态方法，返回对象实例，当调用该方法时，才会去创建instance实例
    private static synchronized SingletonWithLazyTF getInstance() {
        if(instance == null) {
            instance = new SingletonWithLazyTF();
        }

        return instance;
    }

    public static void main(String[] args) {
        SingletonWithLazyTF lsi = SingletonWithLazyTF.getInstance();
        SingletonWithLazyTF lsi2 = SingletonWithLazyTF.getInstance();
        System.out.println(lsi.equals(lsi2));
    }
}
