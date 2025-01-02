package liiuf.dp.beh.cor.exp01;

public class ConcreteHandler3 extends BaseHandler {
    public void handler(String request) {
        if("ccc".equals(request)) {
            System.err.println("===ccc===");
        } else {
            System.err.println("===没有处理ddd===");
        }
    }
}