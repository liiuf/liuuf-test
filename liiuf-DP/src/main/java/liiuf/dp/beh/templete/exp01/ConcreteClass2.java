package liiuf.dp.beh.templete.exp01;

public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("模版2->doSomething======");
    }

    @Override
    protected void doAnything() {
        System.out.println("模版2->doAnything======");
    }

    public boolean hook() {
        return false;
    }
}