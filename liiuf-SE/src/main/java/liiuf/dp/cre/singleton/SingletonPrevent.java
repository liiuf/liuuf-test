package liiuf.dp.cre.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 以静态内部类为例：避免反射和序列化
 */
public class SingletonPrevent implements Serializable {
    // 私有构造方法增加if判断
    private SingletonPrevent() {
        if(SingletonInner.instance != null) {
            throw new RuntimeException("不允许非法访问!!!");
        }
    }

    private static class SingletonInner {
        private static final SingletonPrevent instance = new SingletonPrevent();
    }

    public static SingletonPrevent getInstance() {
        return SingletonInner.instance;
    }

    // 只需要在单例类中定义ReadResolve方法，就可以解决序列化对于单例的破坏
    private Object readResolve() {
        return SingletonInner.instance;
    }

    public static void main(String[] args) throws Exception {
        // 测试反射
//        Class clazz = SingletonPrevent.class;
//        Constructor<SingletonPrevent> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        SingletonPrevent fsi = constructor.newInstance();
//        SingletonPrevent fsi2 = SingletonPrevent.getInstance();
//        System.out.println(fsi.equals(fsi2));

        // 测试序列化
        SingletonPrevent instance = SingletonPrevent.getInstance();
        try (FileOutputStream fos = new FileOutputStream("singleton.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("singleton.obj");
             ObjectInputStream oos = new ObjectInputStream(fis)) {
            SingletonPrevent readSingleton = (SingletonPrevent) oos.readObject();
            System.out.println(readSingleton.equals(SingletonPrevent.getInstance()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}