package liiuf.dp.beh.visitor.exp01.vis;

import liiuf.dp.beh.visitor.exp01.ele.ConcreteElementA;
import liiuf.dp.beh.visitor.exp01.ele.ConcreteElementB;

public interface Visitor {
    public void visit(ConcreteElementA e);

    public void visit(ConcreteElementB e);
}
