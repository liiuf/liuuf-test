package liiuf.dp.beh.mediator.exp01;

/**
 * 在Mediator抽象类中我们只定义了同事类的注入，为什么使用同事实现类注入而不使用抽象类注入呢?
 * 因为同事类虽然有抽象，但是没有每个同事类必须要完成的业务方法，当然如果每个同事类都有相同的方法，比如execute、handler等，
 * 那当然注入抽象类，做到依赖倒置。
 */
public abstract class Mediator {
    // 定义同事类
    protected ConcreteColleague concreteColleague;
    protected ConcreteColleague2 concreteColleague2;

    public ConcreteColleague getConcreteColleague() {
        return concreteColleague;
    }

    public void setConcreteColleague(ConcreteColleague concreteColleague) {
        this.concreteColleague = concreteColleague;
    }

    public ConcreteColleague2 getConcreteColleague2() {
        return concreteColleague2;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }

    // 中介者模式的业务逻辑
    public abstract void doSomething();
    public abstract void doSomething2();
}