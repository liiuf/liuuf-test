package liiuf.dp.stru.proxy.sta.ex1;

public class Ex1Client {
    public static void main(String[] args) {
        IService service = new ProxyService("ra");
        service.doSomething();
    }
}