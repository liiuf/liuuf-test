package liiuf.dp.beh.state.exp01;

public class ConcreteState implements State {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void doThis() {
        System.out.println("===本状态下必须处理的业务===");
    }

    @Override
    public void doThat() {
        this.context.changeState(new ConcreteState2());
    }
}
