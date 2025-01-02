package liiuf.dp.stru.decorator.dec;

import liiuf.dp.stru.decorator.comp.Component;

public class ConcreteDecorators extends BaseDecorator {
    public ConcreteDecorators(Component component) {
        super(component);
    }

    public void exec() {
        this.extra();
        super.exec();
    }

    public void extra() {
        System.out.println("装饰一下======");
    }
}