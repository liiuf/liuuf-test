package liiuf.dp.stru.proxy.ja;

import liiuf.dp.stru.proxy.ja.bean.IProxyService;
import liiuf.dp.stru.proxy.ja.bean.ProxyService;

public class ProxyClient {
    public static void main(String[] args) {
        // 第一种测试
        IProxyService proxyService = new ProxyService();
        ProxyFactory.getProxy(proxyService).exec();
        // 这样调用会报错
//        ProxyFactory.getProxy(new ProxyService()).exec();
        System.out.println("-------------------------------------------");
        // 第二种测试
        ProxyFactory2.getProxy(proxyService).exec();
        System.out.println("-------------------------------------------");
        // 第三种测试
        ProxyFactory3 proxyFactory3 = new ProxyFactory3();
        proxyFactory3.setTarget(proxyService);
        IProxyService proxy = (IProxyService) proxyFactory3.getProxy();
        proxy.exec();
    }
}