package liiuf.dp.beh.cmd.exp01;

public class ConcreteCommand implements Command {
    private Receiver receiver;
    private String params;

    public ConcreteCommand(Receiver receiver, String params) {
        this.receiver = receiver;
        this.params = params;
    }

    @Override
    public void execute() {
        this.receiver.doSomething(params);
    }
}
