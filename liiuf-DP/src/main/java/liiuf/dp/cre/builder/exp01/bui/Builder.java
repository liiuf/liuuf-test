package liiuf.dp.cre.builder.exp01.bui;

/**
 * 生成器接口声明了创建产品对象不同部件的方法。
 */
public interface Builder {
    public void reset();
    public void buildStepA();
    public void buildStepB();
    public void buildStepC();
    public Object getProduct();
}