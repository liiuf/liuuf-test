package liiuf.dp.beh.iterator;

import liiuf.dp.beh.iterator.exp01.coll.ConcreteCollection;
import liiuf.dp.beh.iterator.exp01.iter.DIterator;
import org.junit.Test;

/**
 * @简介
 * - 它提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 * - 迭代器模式是一种行为设计模式， 让你能在不暴露集合底层表现形式 （列表、 栈和树等） 的情况下遍历集合中所有的元素。
 * - 迭代器是为容器服务的，那什么是容器呢？ 能容纳对象的所有类型都可以称之为容器，例如Collection集合类型、Set类型等，
 *  迭代器模式就是为解决遍历这些容器中的元素而诞生的。
 * - 迭代器模式（Iterator Pattern）目前已经是一个没落的模式，基本上没人会单独写一个迭代器，除非是产品性质的开发，Java集合是自带迭代器的。
 * - 通过对象方式实现。
 */
public class IteratorClient {
    @Test
    public void testIterator() {
        ConcreteCollection cc = new ConcreteCollection();
        DIterator iterator = cc.getDIterator();
        while (iterator.hasNext()) {
            System.out.println("Name: " + iterator.next());
        }
    }
}