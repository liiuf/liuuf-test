package liiuf.dp.beh.mediator;

import liiuf.dp.beh.mediator.exp02.*;
import org.junit.Test;

/**
 * @简介 - 用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * - 中介者模式是一种行为设计模式， 能让你减少对象之间混乱无序的依赖关系。 该模式会限制对象之间的直接交互， 迫使它们通过一个中介者对象进行合作。
 * @优缺点 #优点
 * - 单一职责原则。 你可以将多个组件间的交流抽取到同一位置， 使其更易于理解和维护。
 * - 开闭原则。 你无需修改实际组件就能增加新的中介者。
 * - 可以减轻应用中多个组件间的耦合情况。
 * - 可以更方便地复用各个组件。
 * #缺点
 * - 中介者模式的缺点就是中介者会膨胀得很大，而且逻辑复杂，原本N个对象直接的相互依赖关系转换为中介者和同事类的依赖关系，同事类越多，中介者的逻辑就越复杂。
 * @使用场景 - 当一些对象和其他对象紧密耦合以致难以对其进行修改时，可使用中介者模式。该模式让你将对象间的所有关系抽取成为一个单独的类，以使对于特定组件的
 * 修改工作独立于其他组件。
 * - 当组件因过于依赖其他组件而无法在不同应用中复用时，可使用中介者模式。应用中介者模式后，每个组件不再知晓其他组件的情况。尽管这些组件无法直接交流，
 * 但它们仍可通过中介者对象进行间接交流。如果你希望在不同应用中复用一个组件，则需要为其提供一个新的中介者类。
 * - 如果为了能在不同情景下复用一些基本行为，导致你需要被迫创建大量组件子类时，可使用中介者模式。由于所有组件间关系都被包含在中介者中，因此你无需修改
 * 组件就能方便地新建中介者类以定义新的组件合作方式。
 * - 多个对象之间紧密耦合的情况，紧密耦合的标准是：在类图中出现了蜘蛛网状结构。在这种情况下一定要考虑使用中介者模式，这有利于把蜘蛛网梳理为星型结构，
 * 使原本复杂混乱的关系变得清晰简单。
 * - N个对象之间产生了相互的依赖关系（N＞2）。
 * - 多个对象有依赖关系，但是依赖的行为尚不确定或者有发生改变的可能，在这种情况下一般建议采用中介者模式，降低变更引起的风险扩散。
 * - 产品开发。一个明显的例子就是MVC框架，把中介者模式应用到产品中，可以提升产品的性能和扩展性，但是对于项目开发就未必，因为项目是以交付投产为目标，
 * 而产品则是以稳定、高效、扩展为宗旨。
 * @思路 - 找到一组当前紧密耦合，且提供其独立性能带来更大好处的类（例如更易于维护或更方便复用）。
 * - 声明中介者接口并描述中介者和各种组件之间所需的交流接口。在绝大多数情况下，一个接收组件通知的方法就足够了。如果你希望在不同情景下复用组件类，
 * 那么该接口将非常重要。只要组件使用通用接口与其中介者合作，你就能将该组件与不同实现中的中介者进行连接。
 * - 实现具体中介者类。该类可从自行保存其下所有组件的引用中受益。
 * - 你可以更进一步，让中介者负责组件对象的创建和销毁。此后，中介者可能会与工厂或外观类似。
 * - 组件必须保存对于中介者对象的引用。连接通常在组件的构造函数中建立，该函数会将中介者对象作为参数传递。
 * - 修改组件代码，使其可调用中介者的通知方法，而非其他组件的方法。然后将调用其他组件的代码抽取到中介者类中，并在中介者接收到该组件通知时执行这些代码。
 */
public class MediatorClient {
    /**
     * @分类 - Mediator 抽象中介者角色，抽象中介者角色定义统一的接口，用于各同事角色之间的通信。
     * - Concrete Mediator 具体中介者角色，具体中介者角色通过协调各同事角色实现协作行为，因此它必须依赖于各个同事角色。
     * - Colleague 同事角色，每一个同事角色都知道中介者角色，而且与其他的同事角色通信的时候，一定要通过中介者角色协作。
     * 每个同事类的行为分为两种：一种是同事本身的行为，比如改变对象本身的状态，处理自己的行为等，这种行为叫做自发行为（Self-Method），
     * 与其他的同事类或中介者没有任何的依赖；第二种是必须依赖中介者才能完成的行为，叫做依赖方法（Dep-Method）。
     */
    @Test
    public void testExp01() {
    }

    /**
     * @分类
     * - 组件（Component）是各种包含业务逻辑的类。每个组件都有一个指向中介者的引用，该引用被声明为中介者接口类型。组件不知道中介者实际所属的类，
     *  因此你可通过将其连接到不同的中介者以使其能在其他程序中复用。
     * - 中介者（Mediator） 接口声明了与组件交流的方法，但通常仅包括一个通知方法。组件可将任意上下文（包括自己的对象）作为该方法的参数，只有这样
     *  接收组件和发送者类之间才不会耦合。
     * - 具体中介者（Concrete Mediator）封装了多种组件间的关系。具体中介者通常会保存所有组件的引用并对其进行管理，甚至有时会对其生命周期进行管理。
     * - 组件并不知道其他组件的情况。如果组件内发生了重要事件，它只能通知中介者。中介者收到通知后能轻易地确定发送者，这或许已足以判断接下来需要
     *  触发的组件了。对于组件来说，中介者看上去完全就是一个黑箱。发送者不知道最终会由谁来处理自己的请求，接收者也不知道最初是谁发出了请求。
     */
    @Test
    public void testExp02() {
        ComponentA componentA = new ComponentA();
        ComponentB componentB = new ComponentB();
        ComponentC componentC = new ComponentC();
        ComponentD componentD = new ComponentD();

        ConcreteMediator2 mediator = new ConcreteMediator2(componentA, componentB, componentC, componentD);
        componentA.setMediator(mediator);
        componentB.setMediator(mediator);
        componentC.setMediator(mediator);
        componentD.setMediator(mediator);

        // 进行操作
        componentA.operation();
        componentB.operation();
        componentC.operation();
        componentD.operation();
    }
}