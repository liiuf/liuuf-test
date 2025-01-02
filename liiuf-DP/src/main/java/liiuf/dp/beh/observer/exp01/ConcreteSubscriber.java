package liiuf.dp.beh.observer.exp01;

public class ConcreteSubscriber implements Subscriber {
    @Override
    public void update() {
        System.out.println("===开始观察了===");
    }
}