package liiuf.dp.stru.flyweight.exp02;

/**
 * 实现自己的业务逻辑，然后接收外部状态，以便内部业务逻辑对外部状态的依赖。注意，我们在抽象享元中对外部状态加上了final关键字，为了防止什么问题？
 * Client获得了一个外部状态，然后无意修改了一下，池就混乱了！
 * 在程序开发中，确认只需要一次赋值的属性则设置为final类型，避免无意修改导致逻辑混乱，特别是Session级的常量或变量。
 */
public class ConcreteFlyweight02 extends Flyweight02 {
    // 接收外部状态
    public ConcreteFlyweight02(String _extrinsic) {
        super(_extrinsic);
    }

    // 根据外部状态进行业务处理
    @Override
    public void operate() {
        System.out.println("根据外部状态进行业务处理======");
    }
}