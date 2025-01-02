package liiuf.dp.beh.memo;

import liiuf.dp.beh.memo.exp01.Caretaker;
import liiuf.dp.beh.memo.exp01.Originator;
import org.junit.Test;

/**
 * @简介
 * - 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
 * - 通俗地说，备忘录模式就是一个对象的备份模式，提供了一种程序数据的备份方法。
 * - 备忘录模式是一种行为设计模式，允许在不暴露对象实现细节的情况下保存和恢复对象之前的状态。
 * - 通过对象方式实现。
 *
 * @优缺点
 * #优点
 * - 你可以在不破坏对象封装情况的前提下创建对象状态快照。
 * - 你可以通过让负责人维护原发器状态历史记录来简化原发器代码。
 * #缺点
 * - 如果客户端过于频繁地创建备忘录，程序将消耗大量内存。
 * - 负责人必须完整跟踪原发器的生命周期，这样才能销毁弃用的备忘录。
 * - 绝大部分动态编程语言（例如 PHP、Python 和 JavaScript）不能确保备忘录中的状态不被修改。
 * #注意
 * - 备忘录的生命期：备忘录创建出来就要在“最近”的代码中使用，要主动管理它的生命周期，建立就要使用，不使用就要立刻删除其引用，
 *  等待垃圾回收器对它的回收处理。
 * - 备忘录的性能：不要在频繁建立备份的场景中使用备忘录模式（比如一个for循环中），原因有二：一是控制不了备忘录建立的对象数量；
 *  二是大对象的建立是要消耗资源的，系统的性能需要考虑。
 *
 * @使用场景
 * - 当你需要创建对象状态快照来恢复其之前的状态时，可以使用备忘录模式。备忘录模式允许你复制对象中的全部状态（包括私有成员变量），
 *  并将其独立于对象进行保存。尽管大部分人因为 “撤销” 这个用例才记得该模式，但其实它在处理事务（比如需要在出现错误时回滚一个操作）的过程中也必不可少。
 * - 当直接访问对象的成员变量、获取器或设置器将导致封装被突破时，可以使用该模式。备忘录让对象自行负责创建其状态的快照。
 *  任何其他对象都不能读取快照，这有效地保障了数据的安全性。
 *
 * @思路
 * - 确定担任原发器角色的类。重要的是明确程序使用的一个原发器中心对象，还是多个较小的对象。
 * - 创建备忘录类。逐一声明对应每个原发器成员变量的备忘录成员变量。
 * - 将备忘录类设为不可变。备忘录只能通过构造函数一次性接收数据。该类中不能包含设置器。
 * - 如果你所使用的编程语言支持嵌套类，则可将备忘录嵌套在原发器中；如果不支持，那么你可从备忘录类中抽取一个空接口，然后让其他所有对象通过接口来
 *  引用备忘录。你可在该接口中添加一些元数据操作，但不能暴露原发器的状态。
 * - 在原发器中添加一个创建备忘录的方法。原发器必须通过备忘录构造函数的一个或多个实际参数来将自身状态传递给备忘录。该方法返回结果的类型必须是你在
 *  上一步中抽取的接口（如果你已经抽取了）。实际上，创建备忘录的方法必须直接与备忘录类进行交互。
 * - 在原发器类中添加一个用于恢复自身状态的方法。该方法接受备忘录对象作为参数。如果你在之前的步骤中抽取了接口，那么可将接口作为参数的类型。
 *  在这种情况下，你需要将输入对象强制转换为备忘录，因为原发器需要拥有对该对象的完全访问权限。
 * - 无论负责人是命令对象、历史记录或其他完全不同的东西，它都必须要知道何时向原发器请求新的备忘录、如何存储备忘录以及何时使用特定备忘录来对
 *  原发器进行恢复。
 * - 负责人与原发器之间的连接可以移动到备忘录类中。在本例中，每个备忘录都必须与创建自己的原发器相连接。恢复方法也可以移动到备忘录类中，但只有
 *  当备忘录类嵌套在原发器中，或者原发器类提供了足够多的设置器并可对其状态进行重写时，这种方式才能实现。
 *
 */
public class MementoClient {
    /**
     * @分类
     * - 原发器（Originator）类可以生成自身状态的快照，也可以在需要时通过快照恢复自身状态。
     * - 备忘录（Memento）是原发器状态快照的值对象（value object）。通常做法是将备忘录设为不可变的，并通过构造函数一次性传递数据。
     * - 负责人（Caretaker） 仅知道 “何时” 和 “为何” 捕捉原发器的状态，以及何时恢复状态。负责人通过保存备忘录栈来记录原发器的历史状态。
     *  当原发器需要回溯历史状态时，负责人将从栈中获取最顶部的备忘录，并将其传递给原发器的恢复（restoration）方法。
     * - 在该实现方法中，备忘录类将被嵌套在原发器中。这样原发器就可访问备忘录的成员变量和方法，即使这些方法被声明为私有。
     *  另一方面，负责人对于备忘录的成员变量和方法的访问权限非常有限：它们只能在栈中保存备忘录，而不能修改其状态。
     */
    @Test
    public void testMemento() {
        // 定义原发器
        Originator originator = new Originator();
        originator.setState("on");
        originator.show();
        // 定义备忘录管理
        Caretaker caretaker = new Caretaker();
        // 创建一个备忘录
        caretaker.setMemento(originator.toSave());
        originator.setState("off");
        originator.show();

        originator.restore(caretaker.getMemento());
        originator.show();
    }
}