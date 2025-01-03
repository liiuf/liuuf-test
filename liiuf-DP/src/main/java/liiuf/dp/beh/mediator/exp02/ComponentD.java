package liiuf.dp.beh.mediator.exp02;

public class ComponentD extends Component {
    public void operation() {
        System.out.println("执行D======");
        mediator2.notify(this);
    }

    public void reactOnA() {
        System.out.println("react A======");
    }
}