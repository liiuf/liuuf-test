package liiuf.dp.beh.state;

import liiuf.dp.beh.state.exp01.ConcreteState;
import liiuf.dp.beh.state.exp01.Context;
import liiuf.dp.beh.state.exp01.State;
import org.junit.Test;

public class StateClient {
    @Test
    public void testState() {
        State initState = new ConcreteState();
        Context context = new Context(initState);
        initState.setContext(context);
        context.doThis();
        context.doThat();
        context.doThis();
    }
}