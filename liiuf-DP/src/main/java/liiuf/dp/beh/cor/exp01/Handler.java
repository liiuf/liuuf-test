package liiuf.dp.beh.cor.exp01;

public interface Handler {
    public void setNext(Handler h);
    public void handler(String request);
}