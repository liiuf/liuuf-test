package liiuf.dp.stru.flyweight.exp01;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> pool = new HashMap<>();

    public FlyweightFactory() {
        pool.put("A", new ConcreteFlyweight("A"));
        pool.put("B", new ConcreteFlyweight("B"));
        pool.put("C", new ConcreteFlyweight("C"));
    }

    // 内部状态创建享元对象
    public Flyweight getFlyweight(String state) {
        if(pool.containsKey(state)) {
            System.out.println("=== 享元池中存在，直接复用，state：" + state);
            return pool.get(state);
        } else {
            System.out.println("=== 享元池中不存在，创建并复用，state：" + state);
            Flyweight flyweight = new ConcreteFlyweight(state);
            pool.put(state, flyweight);
            return flyweight;
        }
    }
}
