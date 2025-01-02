package liiuf.dp.beh.cor.exp01;

public class BaseHandler implements Handler {
    private Handler next;
    @Override
    public void setNext(Handler h) {
        this.next = h;
    }

    @Override
    public void handler(String request) {
        if(next != null) {
            next.handler(request);
        }
    }
}