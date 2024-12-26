package liiuf.dp.cre.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 懒汉式
 *
 * 这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，
 * 还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
 *
 * 结论：在实际开发中，不能使用这种方式
 */
public class SingletonWithLazyNTF1 {
    // 构造器私有化，外部不能直接new，但可以使用反射调用
    private SingletonWithLazyNTF1(){}

    // 本类内部声明对象实例
    private static SingletonWithLazyNTF1 instance;

    // 公有静态方法，返回对象实例，当调用该方法时，才会去创建instance实例，线程不安全
    private static SingletonWithLazyNTF1 getInstance() {
        if(instance == null) {
            synchronized (SingletonWithLazyNTF1.class) {
                instance = new SingletonWithLazyNTF1();
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Map<Integer, String> container = new ConcurrentHashMap<>();
        // 验证多线程不安全
        for(int i = 0; i < 3000; i++) {
            new Thread(() -> {
                SingletonWithLazyNTF1 tsi = SingletonWithLazyNTF1.getInstance();
                container.putIfAbsent(tsi.hashCode(), "1");
                if(!container.isEmpty() && !container.containsKey(tsi.hashCode())) {
                    System.out.println("存在多个实例!!!");
                }
            }).start();
        }
    }
}