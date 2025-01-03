package liiuf.dp.beh.Interpreter.exp01;

/**
 * 通常，终结符表达式比较简单，主要是处理场景元素和数据的转换。
 */
public class TerminalExpression extends Expression {
    // 通常，终结表达式只有一个，但是有多个对象
    @Override
    public Object interpreter(Context ctx) {
        return null;
    }
}