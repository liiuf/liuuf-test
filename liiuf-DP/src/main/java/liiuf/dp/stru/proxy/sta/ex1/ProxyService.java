package liiuf.dp.stru.proxy.sta.ex1;

public class ProxyService implements IService {
    // 目标服务
    private IService realService;
    public ProxyService(String name) {
        realService = new ConcreteService(this, name);
    }

    @Override
    public void doSomething() {
        System.out.println("开始了");
        this.realService.doSomething();
        System.out.println("结束了");
    }
}