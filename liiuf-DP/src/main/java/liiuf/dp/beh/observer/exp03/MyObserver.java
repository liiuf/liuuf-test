package liiuf.dp.beh.observer.exp03;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Received update: " + arg);
    }
}