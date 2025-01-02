package liiuf.dp.beh.state.exp01;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void changeState(State state) {
        this.state = state;

    }

    public void doThis() {
        state.doThis();
    }

    public void doThat() {
        state.doThat();
    }
}