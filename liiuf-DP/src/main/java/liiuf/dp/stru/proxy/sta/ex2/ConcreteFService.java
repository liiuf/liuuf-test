package liiuf.dp.stru.proxy.sta.ex2;

public class ConcreteFService implements IFService {
    private String name;
    private IFService proxy;

    public ConcreteFService(String name) {
        this.name = name;
    }

    @Override
    public void doSomething() {
        if(isProxy()) {
            System.out.println(name + " force proxy======");
        }
    }

    @Override
    public IFService getProxy() {
        this.proxy = new ConcreteFProxyService(this);
        return this.proxy;
    }

    private boolean isProxy() {
        if(this.proxy == null || !(this.proxy instanceof ConcreteFProxyService)) {
            return false;
        }

        return true;
    }
}