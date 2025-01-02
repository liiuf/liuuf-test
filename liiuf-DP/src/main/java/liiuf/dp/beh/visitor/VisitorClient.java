package liiuf.dp.beh.visitor;

import liiuf.dp.beh.visitor.exp01.ele.ConcreteElementA;
import liiuf.dp.beh.visitor.exp01.ele.Element;
import liiuf.dp.beh.visitor.exp01.vis.ConcreteVisitor;
import org.junit.Test;

/**
 * @简介
 * - 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
 * - 访问者模式是一种行为设计模式，它能将算法与其所作用的对象隔离开来。
 * - 通过对象方式实现。
 *
 * @分类
 * - 访问者（Visitor） 接口声明了一系列以对象结构的具体元素为参数的访问者方法。如果编程语言支持重载，这些方法的名称可以是相同的，
 *  但是其参数一定是不同的。
 * - 具体访问者（Concrete Visitor）会为不同的具体元素类实现相同行为的几个不同版本。
 * - 元素（Element） 接口声明了一个方法来 “接收” 访问者。该方法必须有一个参数被声明为访问者接口类型。
 * - 具体元素（Concrete Element）必须实现接收方法。该方法的目的是根据当前元素类将其调用重定向到相应访问者的方法。
 *  请注意，即使元素基类实现了该方法，所有子类都必须对其进行重写并调用访问者对象中的合适方法。
 * - 客户端（Client）通常会作为集合或其他复杂对象（例如一个组合树）的代表。客户端通常不知晓所有的具体元素类，因为它们会通过抽象接口与集合中的
 *  对象进行交互。
 *
 * @优缺点
 * 优缺点
 * #优点
 * - 开闭原则。你可以引入在不同类对象上执行的新行为，且无需对这些类做出修改。
 * - 单一职责原则。可将同一行为的不同版本移到同一个类中。
 * - 访问者对象可以在与各种对象交互时收集一些有用的信息。当你想要遍历一些复杂的对象结构（例如对象树），并在结构中的每个对象上应用访问者时，
 *  这些信息可能会有所帮助。
 * #缺点
 * - 每次在元素层次结构中添加或移除一个类时，你都要更新所有的访问者。
 * - 访问者同某个元素进行交互时，它们可能没有访问元素私有成员变量和方法的必要权限。
 * - 具体元素对访问者公布细节：访问者要访问一个类就必然要求这个类公布一些方法和数据，也就是说访问者关注了其他类的内部细节，这是迪米特法则所不建议的。
 * - 违背了依赖倒置转原则：访问者依赖的是具体元素，而不是抽象元素，这破坏了依赖倒置原则，特别是在面向对象的编程中，抛弃了对接口的依赖，
 *  而直接依赖实现类，扩展比较难。
 *
 * @使用场景
 * - 如果你需要对一个复杂对象结构（例如对象树）中的所有元素执行某些操作，可使用访问者模式。访问者模式通过在访问者对象中为多个目标类提供相同操作的变体，
 *  让你能在属于不同类的一组对象上执行同一操作。
 * - 可使用访问者模式来清理辅助行为的业务逻辑。该模式会将所有非主要的行为抽取到一组访问者类中，使得程序的主要类能更专注于主要的工作。
 * - 当某个行为仅在类层次结构中的一些类中有意义，而在其他类中没有意义时，可使用该模式。你可将该行为抽取到单独的访问者类中，只需实现接收相关类的对象
 *  作为参数的访问者方法并将其他方法留空即可。
 *
 * @思路
 * - 在访问者接口中声明一组 “访问” 方法，分别对应程序中的每个具体元素类。
 * - 声明元素接口。如果程序中已有元素类层次接口，可在层次结构基类中添加抽象的 “接收” 方法。该方法必须接受访问者对象作为参数。
 * - 在所有具体元素类中实现接收方法。这些方法必须将调用重定向到当前元素对应的访问者对象中的访问者方法上。
 * - 元素类只能通过访问者接口与访问者进行交互。不过访问者必须知晓所有的具体元素类，因为这些类在访问者方法中都被作为参数类型引用。
 * - 为每个无法在元素层次结构中实现的行为创建一个具体访问者类并实现所有的访问者方法。你可能会遇到访问者需要访问元素类的部分私有成员变量的情况。在这
 *  种情况下，你要么将这些变量或方法设为公有，这将破坏元素的封装；要么将访问者类嵌入到元素类中。后一种方式只有在支持嵌套类的编程语言中才可能实现。
 * - 客户端必须创建访问者对象并通过 “接收” 方法将其传递给元素。
 *
 */
public class VisitorClient {
    @Test
    public void testVisitor() {
        Element e = new ConcreteElementA();
        e.accept(new ConcreteVisitor());
    }
}