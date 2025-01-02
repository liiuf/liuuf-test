package liiuf.dp.beh.observer.exp02;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * 观察者/监听
 */
public class PersonListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property " + evt.getPropertyName() + " changed from "
                + evt.getOldValue() + " to " + evt.getNewValue());
    }
}