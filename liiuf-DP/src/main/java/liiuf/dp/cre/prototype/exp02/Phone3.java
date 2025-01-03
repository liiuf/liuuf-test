package liiuf.dp.cre.prototype.exp02;

import java.io.*;

/**
 * 一个实现了Cloneable并重写了clone方法的类A，有一个无参构造或有参构造B，通过new关键字产生了一个对象S，再然后通过S.clone()方式
 * 产生了一个新的对象T，那么在对象拷贝时构造函数B是不会被执行的。因为Object类的clone方法的原理是从内存中（具体地说就是堆内存）以二进制流
 * 的方式进行拷贝，重新分配一个内存块。
 */
public class Phone3 implements Cloneable {
    private String band;
    private String color;
    private String type;
    private Owner owner;

    public Phone3(String band, String color, String type, Owner owner) {
        this.band = band;
        this.color = color;
        this.type = type;
        this.owner = owner;
    }

    /**
     * 浅copy，Phone3的子属性Owner没有被复制，指向的是同一个对象实例，实际上，不止自定义的类型会有这个问题，
     * 使用Intger等包装类型也会出现则会个问题。
     * 引用对象执行的是同一个对象，修改会相互影响。
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Phone3{" +
                "band='" + band + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }
}