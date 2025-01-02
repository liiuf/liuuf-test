package liiuf.dp.stru.adapter.cla.adap;

import liiuf.dp.stru.adapter.cla.tar.Target;

public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
