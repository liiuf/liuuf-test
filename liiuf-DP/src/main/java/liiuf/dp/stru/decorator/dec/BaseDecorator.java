package liiuf.dp.stru.decorator.dec;

import liiuf.dp.stru.decorator.comp.Component;

public class BaseDecorator implements Component {
    private Component wrapper;

    public BaseDecorator(Component wrapper) {
        this.wrapper = wrapper;
    }
    @Override
    public void exec() {
        this.wrapper.exec();
    }
}