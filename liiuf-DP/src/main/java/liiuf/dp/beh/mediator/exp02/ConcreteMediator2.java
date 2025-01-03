package liiuf.dp.beh.mediator.exp02;

/**
 * ConcreteMediator 负责协调组件之间的交互，而每个组件通过调用 mediator.notify(this) 向中介者发送通知。
 * 中介者根据发送者的类型调用相应的反应方法。
 */
public class ConcreteMediator2 implements Mediator2 {
    private ComponentA componentA;
    private ComponentB componentB;
    private ComponentC componentC;
    private ComponentD componentD;

    public ConcreteMediator2(ComponentA a, ComponentB b, ComponentC c, ComponentD d) {
        this.componentA = a;
        this.componentB = b;
        this.componentC = c;
        this.componentD = d;
    }

    // 注：reactOn方法也可以写在中介者类中，也可以写在具体的组件类中
    @Override
    public void notify(Component component) {
        if(component == componentA) {
            componentA.reactOnB();
        } else if(component == componentB) {
            componentB.reactOnC();
        } else if(component == componentC) {
            componentC.reactOnD();
        } else if(component == componentD) {
            componentD.reactOnA();
        }
    }
}