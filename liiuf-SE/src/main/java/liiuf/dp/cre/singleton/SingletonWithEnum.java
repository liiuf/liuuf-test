package liiuf.dp.cre.singleton;

/**
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化、反射绕过单例重新创建新的对象。
 *
 * 预防反射攻击及反序列化攻击
 *
 * 总结：推荐使用
 */
public class SingletonWithEnum {
    public static void main(String[] args) {
        Singleton si = Singleton.INSTANCE;
        Singleton si2 = Singleton.INSTANCE;
        System.out.println(si.equals(si2));
        si.say();
    }
}

enum Singleton {
    INSTANCE;

    public void say() {
        System.out.println("hello");
    }
}