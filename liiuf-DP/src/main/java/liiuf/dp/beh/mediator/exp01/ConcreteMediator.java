package liiuf.dp.beh.mediator.exp01;

public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething() {
        // 调用同事类的方法，只要是public方法都可以调用
        super.concreteColleague.selfMethod();
        super.concreteColleague2.selfMethod();
    }

    @Override
    public void doSomething2() {
        super.concreteColleague.selfMethod();
        super.concreteColleague2.selfMethod();
    }
}