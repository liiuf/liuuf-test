package liiuf.dp.beh.strategy.exp01;

public class ConcreteStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("===执行具体策略===");
    }
}