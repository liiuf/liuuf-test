package liiuf.dp.stru.proxy.cg;

import liiuf.dp.stru.proxy.cg.bean.CgProxyBean;

public class CgProxyClient {
    public static void main(String[] args) {
        CgProxyBean proxy = (CgProxyBean) new CgProxyFactory().getProxy(new CgProxyBean());
        proxy.exec();
    }
}