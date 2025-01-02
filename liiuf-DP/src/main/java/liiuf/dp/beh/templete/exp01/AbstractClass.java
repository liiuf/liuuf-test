package liiuf.dp.beh.templete.exp01;

public abstract class AbstractClass {
    // 基本方法-也可以是使用public，子类实现
    protected abstract void doSomething();
    // 基本方法-也可以使用public，子类实现
    protected abstract void doAnything();
    // 模版方法-可以用final修饰
    public void templateMethod() {
        this.doAnything();
        if(hook()) {
            this.doSomething();
        }
    }

    public boolean hook() {
        return true;
    }
}