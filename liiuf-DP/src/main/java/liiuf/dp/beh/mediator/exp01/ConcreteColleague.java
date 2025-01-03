package liiuf.dp.beh.mediator.exp01;

public class ConcreteColleague extends Colleague {
    // 通过构造器传递中介者
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    // 中介者自有方法
    public void selfMethod() {

    }

    public void depMethod() {
        // 处理自己的业务逻辑
        // 自己不能处理的业务逻辑，委托给中介者处理

    }
}