package liiuf.dp.beh.observer.exp02;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 被观察者
 */
public class Person {
    private String name;
    private final PropertyChangeSupport support;

    public Person() {
        support = new PropertyChangeSupport(this);
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        support.firePropertyChange("name", oldName, name);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}