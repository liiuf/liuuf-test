package liiuf.dp.beh.visitor.exp01.ele;

import liiuf.dp.beh.visitor.exp01.vis.Visitor;

public class ConcreteElementA implements Element {
    public void featureA() {
        System.out.println("访问A======");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}