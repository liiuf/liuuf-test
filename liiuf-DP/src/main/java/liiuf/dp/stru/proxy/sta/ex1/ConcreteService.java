package liiuf.dp.stru.proxy.sta.ex1;

public class ConcreteService implements IService {
    private String name;

    // 可以在构造方法上加限制，比如必须由谁代理，当然也可以不加
    public ConcreteService(IService service, String name) {
        if(null == service && service instanceof ProxyService) {
            throw new RuntimeException("非法代理");
        } else {
            this.name = name;
        }
    }
    @Override
    public void doSomething() {
        System.out.println(name + " do something======");
    }
}