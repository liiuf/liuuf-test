package liiuf.dp.stru.proxy.sta.ex2;

public class ConcreteFProxyService implements IFService {
    // 目标服务
    private IFService realService;

    public ConcreteFProxyService(IFService service) {
        this.realService = service;
    }
    @Override
    public void doSomething() {
        System.out.println("开始了");
        this.realService.doSomething();
        System.out.println("结束了");
    }

    @Override
    public IFService getProxy() {
        return this;
    }
}