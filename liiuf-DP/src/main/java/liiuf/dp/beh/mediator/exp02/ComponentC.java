package liiuf.dp.beh.mediator.exp02;

public class ComponentC extends Component {
    public void operation() {
        System.out.println("执行C======");
        mediator2.notify(this);
    }

    public void reactOnD() {
        System.out.println("react D======");
    }
}
