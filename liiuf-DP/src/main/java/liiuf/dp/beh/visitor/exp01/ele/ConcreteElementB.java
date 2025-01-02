package liiuf.dp.beh.visitor.exp01.ele;

import liiuf.dp.beh.visitor.exp01.vis.Visitor;

public class ConcreteElementB implements Element {
    public void featureB() {
        System.out.println("访问B======");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}