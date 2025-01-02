package liiuf.dp.stru.flyweight.exp02;

import liiuf.dp.stru.flyweight.exp01.ConcreteFlyweight;
import liiuf.dp.stru.flyweight.exp01.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory02 {
    // 定义一个容器
    private Map<String, Flyweight> pool = new HashMap<>();

    // 在享元模式中，选择根据内部状态还是外部状态创建享元对象取决于具体的设计需求。
    // 一般来说，享元对象内部的状态应是共享的，而外部状态应由客户端管理。
    // 外部状态创建享元对象
    public Flyweight getFlyweight(String extrinsic) {
        // 池中有对象
        if(pool.containsKey(extrinsic)) {
            return pool.get(extrinsic);
        } else {
            // 根据外部状态创建享元对象
            Flyweight flyweight = new ConcreteFlyweight(extrinsic);
            // 放置到池中
            pool.put(extrinsic, flyweight);
            return flyweight;
        }
    }
}