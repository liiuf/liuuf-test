package liiuf.dp.cre.factoryfun.facFun;

import liiuf.dp.cre.factoryfun.bean.ConcreteProduct;
import liiuf.dp.cre.factoryfun.bean.Product;

public class ConcreteFactory1 implements IFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}