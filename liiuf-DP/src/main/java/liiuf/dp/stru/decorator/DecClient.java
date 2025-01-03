package liiuf.dp.stru.decorator;

import liiuf.dp.stru.decorator.comp.Component;
import liiuf.dp.stru.decorator.comp.ConcreteComponent;
import liiuf.dp.stru.decorator.dec.ConcreteDecorators;

/**
 * @介绍：
 * -动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式相比生成子类更为灵活。
 * -装饰模式是一种结构型设计模式， 允许你通过将对象放入包含行为的特殊封装对象中来为原对象绑定新的行为。
 *
 * @分类：
 * - 部件（Component）声明封装器和被封装对象的公用接口。
 * - 具体部件（Concrete Component）类是被封装对象所属的类。它定义了基础行为，但装饰类可以改变这些行为。
 * - 基础装饰（Base Decorator）类拥有一个指向被封装对象的引用成员变量。该变量的类型应当被声明为通用部件接口，
 *  这样它就可以引用具体的部件和装饰。装饰基类会将所有操作委派给被封装的对象。
 * - 具体装饰类（Concrete Decorators）定义了可动态添加到部件的额外行为。具体装饰类会重写装饰基类的方法，并在调用父类方法之前或之后进行额外的行为。
 * - 客户端（Client）可以使用多层装饰来封装部件，只要它能使用通用接口与所有对象互动即可。
 *
 * @优缺点：
 * # 优点
 * - 你无需创建新子类即可扩展对象的行为。
 * - 装饰类和被装饰类可以独立发展，而不会相互耦合。换句话说，Component类无须知道Decorator类，Decorator类是从外部来扩展Component类的功能，
 *  而Decorator也不用知道具体的构件。
 * - 装饰模式是继承关系的一个替代方案。我们看装饰类Decorator，不管装饰多少层，返回的对象还是Component，实现的还是is-a的关系。
 * - 你可以在运行时添加或删除对象的功能。
 * - 你可以用多个装饰封装对象来组合几种行为。
 * - 单一职责原则。 你可以将实现了许多不同行为的一个大类拆分为多个较小的类。
 * # 缺点
 * - 在封装器(装饰器)栈中删除特定封装器比较困难。
 * - 实现行为不受装饰栈顺序影响的装饰比较困难。
 * - 各层的初始化配置代码看上去可能会很糟糕。
 * - 多层的装饰是比较复杂的，因此，尽量减少装饰类的数量，以便降低系统的复杂度。
 *
 * @使用场景：
 * - 如果你希望在无需修改代码的情况下即可使用对象，且希望在运行时为对象新增额外的行为，可以使用装饰模式。装饰能将业务逻辑组织为层次结构，
 * 你可为各层创建一个装饰，在运行时将各种不同逻辑组合成对象。由于这些对象都遵循通用接口，客户端代码能以相同的方式使用这些对象。
 * - 如果用继承来扩展对象行为的方案难以实现或者根本不可行， 你可以使用该模式。许多编程语言使用 final最终关键字来限制对某个类的进一步扩展。
 *  复用最终类已有行为的唯一方法是使用装饰模式： 用封装器对其进行封装。
 *
 * @思路：
 * - 确保业务逻辑可用一个基本组件及多个额外可选层次表示。
 * - 找出基本组件和可选层次的通用方法。创建一个组件接口并在其中声明这些方法。
 * - 创建一个具体组件类，并定义其基础行为。
 * - 创建装饰基类，使用一个成员变量存储指向被封装对象的引用。该成员变量必须被声明为组件接口类型，从而能在运行时连接具体组件和装饰。
 * 装饰基类必须将所有工作委派给被封装的对象。
 * - 确保所有类实现组件接口。
 * - 将装饰基类扩展为具体装饰。具体装饰必须在调用父类方法 （总是委派给被封装对象）之前或之后执行自身的行为。
 * - 客户端代码负责创建装饰并将其组合成客户端所需的形式。
 */
public class DecClient {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecorators cd  = new ConcreteDecorators(component);
        cd.exec();
    }
}