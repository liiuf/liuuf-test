package liiuf.dp.beh.cor.exp01;

public class ConcreteHandler extends BaseHandler {
    public void handler(String request) {
        if("aaa".equals(request)) {
            System.err.println("===aaa===");
        } else {
            super.handler(request);
        }
    }
}