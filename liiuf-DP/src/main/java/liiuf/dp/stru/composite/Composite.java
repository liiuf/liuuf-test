package liiuf.dp.stru.composite;

import java.util.ArrayList;

public class Composite implements Component {
    // 构件容器
    private ArrayList<Component> children = new ArrayList<>();

    // 增加一个叶子构件或树枝构件
    public void add(Component component) {
        this.children.add(component);
    }

    // 删除一个叶子构件或树枝构件
    public void remove(Component component) {
        this.children.remove(component);
    }

    // 获取分支下所有叶子构件和树枝构件
    public ArrayList<Component> getChildren() {
        return this.children;
    }

    @Override
    public void execute() {

    }
}