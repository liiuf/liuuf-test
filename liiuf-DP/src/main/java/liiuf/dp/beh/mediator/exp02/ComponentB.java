package liiuf.dp.beh.mediator.exp02;

public class ComponentB extends Component {
    public void operation() {
        System.out.println("执行B======");
        mediator2.notify(this);
    }

    public void reactOnC() {
        System.out.println("react C======");
    }
}
