package liiuf.dp.stru.bridge;

import liiuf.dp.stru.bridge.abs.Abstraction;
import liiuf.dp.stru.bridge.abs.RefinedAbstraction;
import liiuf.dp.stru.bridge.impl.ConcreteImplementorA;
import liiuf.dp.stru.bridge.impl.Implementor;

/**
 *
 *
 */
public class BridgeClient {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}