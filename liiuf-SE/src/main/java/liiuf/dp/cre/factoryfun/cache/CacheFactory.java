package liiuf.dp.cre.factoryfun.cache;

import liiuf.dp.cre.factoryfun.bean.ConcreteProduct;
import liiuf.dp.cre.factoryfun.bean.ConcreteProduct2;
import liiuf.dp.cre.factoryfun.bean.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheFactory {
    private static final Map<String, Product> cache = new ConcurrentHashMap<>();

    public static synchronized Product createProduct(String type) {
        Product product = null;

        if(cache.containsKey(type)) {
            product = cache.get(type);
        } else {
            if(type.equals("p1")) {
                product = new ConcreteProduct();
            } else {
                product = new ConcreteProduct2();
            }

            cache.put(type, product);
        }

        return product;
    }

    public static void main(String[] args) {
        CacheFactory.createProduct("p1").exec();
        CacheFactory.createProduct("p2").exec();
    }
}