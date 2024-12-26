package liiuf.dp.cre.factoryfun.simpleFactory;

import liiuf.dp.cre.factoryfun.bean.ConcreteProduct;
import liiuf.dp.cre.factoryfun.bean.ConcreteProduct2;

public class SFClient {
    public static void main(String[] args) {
        ConcreteProduct concreteProduct = SimpleFactory.createByClazzName(ConcreteProduct.class);
        concreteProduct.exec();

        ConcreteProduct2 concreteProduct2 = SimpleFactory.createProduct(ConcreteProduct2.class);
        concreteProduct2.exec();
    }
}