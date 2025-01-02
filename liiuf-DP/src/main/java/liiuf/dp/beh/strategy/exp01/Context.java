package liiuf.dp.beh.strategy.exp01;

public class Context {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        this.strategy.execute();
    }
}