package liiuf.dp.cre.factoryfun.facFun;

import liiuf.dp.cre.factoryfun.bean.Product;

public class FFClient {
    public static void main(String[] args) {
        Product product = new ConcreteFactory1().createProduct();
        product.exec();

        Product product2 = new ConcreteFactory2().createProduct();
        product2.exec();
    }
}