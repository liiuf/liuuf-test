package liiuf.dp.stru.bridge.abs;

import liiuf.dp.stru.bridge.impl.Implementor;

public class Abstraction {
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operationImpl();
    }

    // 为子类提供具体实现类的访问句柄，子类可以灵活调用具体实现类的方法
    public Implementor getImplementor() {
        return this.implementor;
    }
}