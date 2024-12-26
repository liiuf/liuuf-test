package liiuf.dp.cre.factoryfun.simpleFactory;

import liiuf.dp.cre.factoryfun.bean.Product;

public class SimpleFactory {
    /**
     * 什么类型都可以
     *
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T createByClazzName(Class<? extends T> clazz) {
        T obj = null;

        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    /**
     * Product类型的子类
     *
     * @param p
     * @return
     * @param <T>
     */
    public static <T extends Product> T createProduct(Class<T> p) {
        Product product = null;
        try {
            product = (Product) Class.forName(p.getName()).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return (T) product;
    }
}