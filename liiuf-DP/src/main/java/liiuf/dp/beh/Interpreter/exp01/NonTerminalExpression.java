package liiuf.dp.beh.Interpreter.exp01;

/**
 * 每个非终结符表达式都代表了一个文法规则，并且每个文法规则都只关心自己周边的文法规则的结果（注意是结果），因此这就产生了每个
 * 非终结符表达式调用自己周边的非终结符表达式，然后最终、最小的文法规则就是终结符表达式，终结符表达式的概念就是如此，
 * 不能够再参与比自己更小的文法运算了。
 */
public class NonTerminalExpression extends Expression {
    // 每个非终结符表达式都会对其它表达式产生依赖，通过构造函数传入，可使用全局变量保存
    public NonTerminalExpression(Expression... expressions) {

    }

    @Override
    public Object interpreter(Context ctx) {
        // 进行文法处理
        return null;
    }
}