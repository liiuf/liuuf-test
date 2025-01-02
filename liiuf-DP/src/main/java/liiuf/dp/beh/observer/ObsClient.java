package liiuf.dp.beh.observer;

import liiuf.dp.beh.observer.exp01.ConcreteSubscriber;
import liiuf.dp.beh.observer.exp01.Publisher;
import liiuf.dp.beh.observer.exp01.Subscriber;
import liiuf.dp.beh.observer.exp02.Person;
import liiuf.dp.beh.observer.exp02.PersonListener;
import liiuf.dp.beh.observer.exp03.MyObservable;
import liiuf.dp.beh.observer.exp03.MyObserver;
import org.junit.Test;

/**
 * @简介
 * - 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 * - 观察者模式是一种行为设计模式，允许你定义一种订阅机制，可在对象事件发生时通知多个 “观察” 该对象的其他对象。
 * - 通过对象方式实现。
 *
 * @分类
 * - 发布者（Publisher）会向其他对象发送值得关注的事件。事件会在发布者自身状态改变或执行特定行为后发生。
 *  发布者中包含一个允许新订阅者加入和当前订阅者离开列表的订阅构架。
 * - 当新事件发生时，发送者会遍历订阅列表并调用每个订阅者对象的通知方法。该方法是在订阅者接口中声明的。
 * - 订阅者（Subscriber）接口声明了通知接口。在绝大多数情况下，该接口仅包含一个 update更新方法。该方法可以拥有多个参数，
 *  使发布者能在更新时传递事件的详细信息。
 * - 具体订阅者（Concrete Subscribers）可以执行一些操作来回应发布者的通知。所有具体订阅者类都实现了同样的接口，因此发布者不需要与具体类相耦合。
 * - 订阅者通常需要一些上下文信息来正确地处理更新。因此，发布者通常会将一些上下文数据作为通知方法的参数进行传递。发布者也可将自身作为参数进行传递，
 *  使订阅者直接获取所需的数据。
 *
 * @优缺点
 * #优点
 * - 开闭原则。你无需修改发布者代码就能引入新的订阅者类（如果是发布者接口则可轻松引入发布者类）。
 * - 你可以在运行时建立对象之间的联系。
 * - 观察者和被观察者之间是抽象耦合。
 * - 建立一套触发机制。
 * #缺点
 * - 观察者模式需要考虑一下开发效率和运行效率问题，一个被观察者，多个观察者，开发和调试就会比较复杂，而且在Java中消息的通知默认是顺序执行，
 *  一个观察者卡壳，会影响整体的执行效率。在这种情况下，一般考虑采用异步的方式。多级触发时的效率更是让人担忧，大家在设计时注意考虑。
 *
 * @使用场景
 * - 当一个对象状态的改变需要改变其他对象，或实际对象是事先未知的或动态变化的时，可使用观察者模式。
 *  ~ 当你使用图形用户界面类时通常会遇到一个问题。比如，你创建了自定义按钮类并允许客户端在按钮中注入自定义代码，这样当用户按下按钮时就会触发这些代码。
 *  ~ 观察者模式允许任何实现了订阅者接口的对象订阅发布者对象的事件通知。你可在按钮中添加订阅机制，允许客户端通过自定义订阅类注入自定义代码。
 * - 当应用中的一些对象必须观察其他对象时，可使用该模式。但仅能在有限时间内或特定情况下使用。
 *  ~ 订阅列表是动态的，因此订阅者可随时加入或离开该列表。
 * - 关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系。
 * - 事件多级触发场景。
 * - 跨系统的消息交换场景，如消息队列的处理机制。
 *
 * @思路
 * - 仔细检查业务逻辑，试着将其拆分为两个部分：独立于其他代码的核心功能将作为发布者、其它代码则将转化为一组订阅类。
 * - 声明订阅者接口。该接口至少应声明一个 update方法。
 * - 声明发布者接口并定义一些接口来在列表中添加和删除订阅对象。记住发布者必须仅通过订阅者接口与它们进行交互。
 * - 确定存放实际订阅列表的位置并实现订阅方法。通常所有类型的发布者代码看上去都一样，因此将列表放置在直接扩展自发布者接口的抽象类中是显而易见的。
 *  具体发布者会扩展该类从而继承所有的订阅行为。但是，如果你需要在现有的类层次结构中应用该模式，则可以考虑使用组合的方式：
 *  将订阅逻辑放入一个独立的对象，然后让所有实际订阅者使用该对象。
 * - 创建具体发布者类。每次发布者发生了重要事件时都必须通知所有的订阅者。
 * - 在具体订阅者类中实现通知更新的方法。绝大部分订阅者需要一些与事件相关的上下文数据。这些数据可作为通知方法的参数来传递。但还有另一种选择。
 *  订阅者接收到通知后直接从通知中获取所有数据。在这种情况下，发布者必须通过更新方法将自身传递出去。另一种不太灵活的方式是通过构造函数将发布者
 *  与订阅者永久性地连接起来。
 * - 客户端必须生成所需的全部订阅者，并在相应的发布者处完成注册工作。
 *
 */
public class ObsClient {
    @Test
    public void testSubscribe() {
        // 创建一个被观察者(发布)
        Publisher publisher = new Publisher();
        // 定义一个观察者(订阅)
        Subscriber subscriber = new ConcreteSubscriber();
        // 观察者观察被观察者
        publisher.subscribe(subscriber);
        // 观察者开始活动了
        publisher.mainBusinessLogic();
    }

    /**
     * PropertyChangeSupport 是 Java 中用于支持属性更改监听的类，它在 Java Beans 规范中被广泛使用。
     * 该类提供了一种机制，使得对象能够在其属性发生变化时通知注册的监听器。
     * 它极大地方便了 Java Beans 的开发，并使得响应式编程变得更加容易。
     */
    @Test
    public void testBeanChange() {
        Person person = new Person();
        PersonListener personListener = new PersonListener();
        // 添加监听
        person.addPropertyChangeListener(personListener);
        // 修改属性
        person.setName("Alice");
        person.setName("Bob");
        // 移除监听
        person.removePropertyChangeListener(personListener);
    }

    /**
     * 在JAVA语言的java.util库里面，提供了一个Observable类以及一个Observer接口，构成JAVA语言对观察者模式的支持。（JAVA9已弃用）
     * Observable：被观察者。
     * Observer：观察者。
     */
    @Test
    public void testObsForJdk() {
        MyObservable observable = new MyObservable();
        MyObserver observer = new MyObserver();
        // 注册观察者
        observable.addObserver(observer);
        // 修改被观察者的状态
        observable.setMessage("Hello, World!");
        observable.setMessage("Another update!");
    }
}