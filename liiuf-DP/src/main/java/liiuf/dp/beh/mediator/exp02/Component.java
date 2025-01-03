package liiuf.dp.beh.mediator.exp02;

public abstract class Component {
    protected Mediator2 mediator2;

    public void setMediator(Mediator2 mediator) {
        this.mediator2 = mediator;
    }
    public abstract void operation();
}