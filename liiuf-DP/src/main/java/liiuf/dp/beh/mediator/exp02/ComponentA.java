package liiuf.dp.beh.mediator.exp02;

public class ComponentA extends Component {
    public void operation() {
        System.out.println("执行A======");
        mediator2.notify(this);
    }

    public void reactOnB() {
        System.out.println("react B======");
    }
}
