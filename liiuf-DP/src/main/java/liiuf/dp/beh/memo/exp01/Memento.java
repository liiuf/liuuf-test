package liiuf.dp.beh.memo.exp01;

public class Memento {
    // 原发器的内部状态
    private String state;
    // 构造参数传递参数
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}