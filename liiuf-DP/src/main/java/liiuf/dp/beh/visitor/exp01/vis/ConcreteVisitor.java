package liiuf.dp.beh.visitor.exp01.vis;

import liiuf.dp.beh.visitor.exp01.ele.ConcreteElementA;
import liiuf.dp.beh.visitor.exp01.ele.ConcreteElementB;

public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA e) {
        e.featureA();
    }

    @Override
    public void visit(ConcreteElementB e) {
        e.featureB();
    }
}