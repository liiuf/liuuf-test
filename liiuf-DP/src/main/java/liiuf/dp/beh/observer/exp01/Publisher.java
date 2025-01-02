package liiuf.dp.beh.observer.exp01;

import java.util.Vector;

/**
 * 被观察者
 */
public class Publisher {
    private Vector<Subscriber> subscribers = new Vector<Subscriber>();

    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribe() {
        for(Subscriber subscriber : this.subscribers) {
            subscriber.update();
        }
    }

    public void mainBusinessLogic() {
        notifySubscribe();
    }
}