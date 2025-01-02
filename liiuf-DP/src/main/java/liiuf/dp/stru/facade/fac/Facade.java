package liiuf.dp.stru.facade.fac;

import liiuf.dp.stru.facade.sys.ClassC;
import liiuf.dp.stru.facade.sys.SystemA;
import liiuf.dp.stru.facade.sys.SystemB;

public class Facade {
    private SystemA systemA = new SystemA();
    private SystemB systemB = new SystemB();
    private ClassC classC = new ClassC();

    public void methodA() {
        this.systemA.doSomething();
    }

    public void methodB() {
        this.systemB.doSomething();
    }

    public void methodC() {
        this.classC.doSomething();
    }
}
