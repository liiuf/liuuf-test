package liiuf.dp.beh.templete.exp01;

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("模版1->doSomething======");
    }

    @Override
    protected void doAnything() {
        System.out.println("模版1->doAnything======");
    }

    public boolean hook() {
        return true;
    }
}