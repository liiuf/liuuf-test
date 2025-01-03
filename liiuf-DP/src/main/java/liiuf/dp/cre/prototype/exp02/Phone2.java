package liiuf.dp.cre.prototype.exp02;

import java.io.*;

/**
 * 一个实现了Cloneable并重写了clone方法的类A，有一个无参构造或有参构造B，通过new关键字产生了一个对象S，再然后通过S.clone()方式
 * 产生了一个新的对象T，那么在对象拷贝时构造函数B是不会被执行的。因为Object类的clone方法的原理是从内存中（具体地说就是堆内存）以二进制流
 * 的方式进行拷贝，重新分配一个内存块。
 */
public class Phone2 implements Cloneable, Serializable {
    private String band;
    private String color;
    private String type;
    private Owner owner;

    public Phone2(String band, String color, String type, Owner owner) {
        this.band = band;
        this.color = color;
        this.type = type;
        this.owner = owner;
    }

    /**
     * 深copy，引用对象重新生成，修改不相互影响。
     * 也可以使用直接设置值，new对象，然后通过this设置值
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Phone2 phone = null;
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            phone = (Phone2) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return phone;
    }

    @Override
    public String toString() {
        return "Phone2{" +
                "band='" + band + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                '}';
    }
}