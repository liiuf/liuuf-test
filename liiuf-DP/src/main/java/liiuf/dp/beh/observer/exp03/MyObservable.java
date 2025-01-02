package liiuf.dp.beh.observer.exp03;

import java.util.Observable;

/**
 * 被观察者
 */
public class MyObservable extends Observable {
    private String message;

    public void setMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public String getMessage() {
        return message;
    }
}