package liiuf.dp.stru.bridge.abs;

import liiuf.dp.stru.bridge.impl.Implementor;

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    // 也可以不对父类方法进行覆写，使用其它方法名，方法体内调用父类方法即可
    @Override
    public void operation() {
        // 执行修正逻辑，当然也可以调用实现类(如ConcreteImplementorA)的其它方法
        out();
        super.operation();
    }

    public void out() {
        System.out.println("修正一下======");
    }
}