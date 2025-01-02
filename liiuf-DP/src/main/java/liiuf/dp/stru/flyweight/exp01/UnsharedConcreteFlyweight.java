package liiuf.dp.stru.flyweight.exp01;

public class UnsharedConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public UnsharedConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsic) {
        System.out.println("使用不共享对象，内部状态：" + this.intrinsicState + ",外部状态：" + extrinsic);
    }
}