package liiuf.dp.stru.adapter.obj;

public class Adapter implements ClientInterface {
    private Service service;

    public Adapter(Service service) {
        this.service = service;
    }

    @Override
    public void method() {
        this.service.serviceMethod();
    }
}