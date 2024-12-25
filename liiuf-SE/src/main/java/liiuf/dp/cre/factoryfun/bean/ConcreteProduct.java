package liiuf.dp.cre.factoryfun.bean;

public class ConcreteProduct implements Product {
    @Override
    public void exec() {
        System.out.println("ConcreteProduct===");
    }
}
