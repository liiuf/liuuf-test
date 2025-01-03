package liiuf.dp.cre.builder.exp01.bui;

import liiuf.dp.cre.builder.exp01.pro.Product2;

public class ConcreteBuilder2 implements Builder {
    private Product2 product2;
    public ConcreteBuilder2() {
        // 若make调用了reset，则这里可以省略
//        reset();
    }
    @Override
    public void reset() {
        this.product2 = new Product2();
    }

    @Override
    public void buildStepA() {

    }

    @Override
    public void buildStepB() {

    }

    @Override
    public void buildStepC() {

    }

    public Object getProduct() {
        return this.product2;
    }
}
