package liiuf.dp.stru.decorator.comp;

public class ConcreteComponent implements Component {
    @Override
    public void exec() {
        System.out.println("装饰模式测试======");
    }
}