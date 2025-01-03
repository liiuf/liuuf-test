package liiuf.dp.cre.builder.exp01;

import liiuf.dp.cre.builder.exp01.bui.Builder;

/**
 * 主管只负责按照特定顺序执行生成步骤。其在根据特定步骤或配置来生成产品时会很有帮助。由于客户端可以直接控制生成器，
 * 所以严格意义上来说，主管类并不是必需的。
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 主管可同由客户端代码传递给自身的任何生成器实例进行交互。客户端可通过这种方式改变最新组装完毕的产品的最终类型。
     * 主管可使用同样的生成步骤创建多个产品变体，不一定使用构造器方法。
     * @param builder
     */
    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    public void make(String type) {
        builder.reset();
        if(type == "simple") {
            builder.buildStepA();
        } else {
            builder.buildStepB();
            builder.buildStepC();
        }
    }
}