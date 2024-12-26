package liiuf.dp.cre.factoryfun.facFun;

import liiuf.dp.cre.factoryfun.bean.ConcreteProduct2;
import liiuf.dp.cre.factoryfun.bean.Product;

public class ConcreteFactory2 implements IFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}