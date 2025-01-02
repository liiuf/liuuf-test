package liiuf.dp.beh.memo.exp01;

import liiuf.dp.beh.memo.MementoClient;

public class Originator {
    // 内部状态
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 创建一个备忘录
    public Memento toSave() {
        return new Memento(this.state);
    }

    // 恢复一个备忘录
    public void restore(Memento memento) {
        this.setState(memento.getState());
    }

    public void show() {
        System.out.println("state = " + state);
    }
}