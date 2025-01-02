package liiuf.dp.beh.cor.exp01;

public class ConcreteHandler2 extends BaseHandler {
    public void handler(String request) {
        if("bbb".equals(request)) {
            System.err.println("===bbb===");
        } else {
            super.handler(request);
        }
    }
}