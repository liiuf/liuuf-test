package liiuf.dp.stru.proxy.sta.ex2;

public class Ex2Client {
    public static void main(String[] args) {
        // 正常输出
        IFService service = new ConcreteFService("ra");
        IFService proxy = service.getProxy();
        proxy.doSomething();

        // 输出为空，未经过代理，不执行业务
        IFService service1 = new ConcreteFService("ra");
        service1.doSomething();

        // 输出了开始了、结束了，未经过代理不执行代理业务
        IFService service2 = new ConcreteFService("ra");
        IFService proxy2 = new ConcreteFProxyService(service2);
        proxy2.doSomething();
    }
}