package liiuf.dp.cre.builder.exp01.bui;

import liiuf.dp.cre.builder.exp01.pro.Product1;

/**
 * 具体生成器类将遵循生成器接口并提供生成步骤的具体实现。你的程序中可能会有多个以不同方式实现的生成器变体。
 */
public class ConcreteBuilder1 implements Builder {
    private Product1 product1;

    // 一个新的生成器实例必须包含一个在后续组装过程中使用的空产品对象。
    public ConcreteBuilder1() {
        // 若make调用了reset，则这里可以省略
//        reset();
    }

    // reset（重置）方法可清除正在生成的对象。
    @Override
    public void reset() {
        this.product1 = new Product1();
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

    /**
     * 具体生成器需要自行提供获取结果的方法。这是因为不同类型的生成器可能会创建不遵循相同接口的、完全不同的产品。所以也就无法在生成器接口中
     * 声明这些方法。通常在生成器实例将结果返回给客户端后，它们应该做好生成另一个产品的准备。因此生成器实例通常会在 `getReuslt（获取产品）`方法
     * 主体末尾调用重置方法。但是该行为并不是必需的，你也可让生成器等待客户端明确调用重置方法后再去处理之前的结果。
     *
     * @return
     */
    public Object getProduct() {
        return this.product1;
    }
}
