package liiuf.dp.cre.factoryfun.singletonFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonFactory {
    private static Singleton singleton;

    static {
        try {
            Class clazz = Class.forName(Singleton.class.getName());
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        getSingleton().exec();
    }
}

class Singleton {
    private Singleton() {}

    public void exec() {
        System.out.println("SingletonFactory======");
    }
}