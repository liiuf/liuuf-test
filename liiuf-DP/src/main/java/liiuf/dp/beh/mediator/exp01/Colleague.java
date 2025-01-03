package liiuf.dp.beh.mediator.exp01;

/**
 * 为什么同事类要使用构造函数注入中介者，而中介者使用getter/setter方式注入同事类呢?
 * 因为同事类必须有中介者，而中介者却可以只有部分同事类。
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}