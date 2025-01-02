package liiuf.dp.stru.flyweight;

import liiuf.dp.stru.flyweight.exp01.Flyweight;
import liiuf.dp.stru.flyweight.exp01.FlyweightFactory;
import org.junit.Test;

/**
 * @简介：
 * - 使用共享对象可有效地支持大量的细粒度的对象。
 * - 享元模式（Flyweight Pattern）是池技术的重要实现方式。
 * - 享元模式是一种结构型设计模式， 它摒弃了在每个对象中保存所有数据的方式，通过共享多个对象所共有的相同状态，让你能在有限的内存容量中载入更多对象。
 *
 * @优缺点
 * #优点
 * - 如果程序中有很多相似对象， 那么你将可以节省大量内存。
 * #缺点
 * - 你可能需要牺牲执行速度来换取内存，因为他人每次调用享元方法时都需要重新计算部分情景数据。
 * - 码会变得更加复杂。团队中的新成员总是会问：“为什么要像这样拆分一个实体的状态？”。
 *
 * @使用场景
 * - 仅在程序必须支持大量对象且没有足够的内存容量时使用享元模式。应用该模式所获的收益大小取决于使用它的方式和情景。 它在下列情况中最有效：
 *  - 程序需要生成数量巨大的相似对象；
 *  - 这将耗尽目标设备的所有内存
 *  - 对象中包含可抽取且能在多个对象间共享的重复状态。
 * - 细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关，也就是说对象没有特定身份。
 * - 要缓冲池的场景。
 *
 * 思路：
 * - 将需要改写为享元的类成员变量拆分为两个部分：
 *  - 内在状态：包含不变的、可在许多对象中重复使用的数据的成员变量。
 *  - 外在状态：包含每个对象各自不同的情景数据的成员变量。
 * - 保留类中表示内在状态的成员变量，并将其属性设置为不可修改。这些变量仅可在构造函数中获得初始数值。
 * - 找到所有使用外在状态成员变量的方法，为在方法中所用的每个成员变量新建一个参数，并使用该参数代替成员变量。
 * - 你可以有选择地创建工厂类来管理享元缓存池，它负责在新建享元时检查已有的享元。如果选择使用工厂，客户端就只能通过工厂来请求享元，它们需要将享元的内在状态作为参数传递给工厂。
 * - 客户端必须存储和计算外在状态（情景）的数值，因为只有这样才能调用享元对象的方法。为了使用方便，外在状态和引用享元的成员变量可以移动到单独的情景类中。
 */
public class FlyweightClient {
    /**
     * - Flyweight-抽象享元角色：它简单地说就是一个产品的抽象类，同时定义出对象的外部状态和内部状态的接口或实现。
     * - ConcreteFlyweight-具体享元角色具体的一个产品类，实现抽象角色定义的业务。该角色中需要注意的是内部状态处理应该与环境无关，
     *  不应该出现一个操作改变了内部状态，同时修改了外部状态，这是绝对不允许的。
     * - UnsharedConcreteFlyweight-不可共享的享元角色不存在外部状态或者安全要求（如线程安全）不能够使用共享技术的对象，
     *  该对象一般不会出现在享元工厂中。
     * - FlyweightFactory-享元工厂：职责非常简单，就是构造一个池容器，同时提供从池中获得对象的方法。享元模式的目的在于运用共享技术，
     *  使得一些细粒度的对象可以共享，我们的设计确实也应该这样，多使用细粒度的对象，便于重用或重构。
     *
     */
    @Test
    public void testFlyweight() {
        FlyweightFactory ff = new FlyweightFactory();
        Flyweight flyweight = ff.getFlyweight("A");
        Flyweight flyweight2 = ff.getFlyweight("A");
        System.out.println(flyweight2 == flyweight);
        System.out.println("------------------------------------------");
        flyweight.operation("a1ExState");
        flyweight2.operation("a2ExState");
        System.out.println(flyweight2 == flyweight);
    }
}