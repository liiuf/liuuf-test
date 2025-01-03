package liiuf.dp.beh.Interpreter.exp01;

/**
 * 抽象表达式是生成语法集合（也叫做语法树）的关键，每个语法集合完成指定语法解析任务，它是通过递归调用的方式，最终由最小的语法单元进行解析完成。
 */
public abstract class Expression {
    // 每个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);
}