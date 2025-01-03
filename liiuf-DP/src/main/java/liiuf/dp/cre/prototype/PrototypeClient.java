package liiuf.dp.cre.prototype;

import liiuf.dp.cre.prototype.exp01.Phone;
import liiuf.dp.cre.prototype.exp02.Owner;
import liiuf.dp.cre.prototype.exp02.Phone2;
import liiuf.dp.cre.prototype.exp02.Phone3;
import org.junit.Test;

/**
 * @简介
 * - 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * - 原型模式是一种创建型设计模式， 使你能够复制已有对象， 而又无需使代码依赖它们所属的类。
 *
 * @优缺点
 * #优点
 * - 你可以克隆对象， 而无需与它们所属的具体类相耦合。
 * - 你可以克隆预生成原型， 避免反复运行初始化代码。
 * - 你可以更方便地生成复杂对象。
 * - 你可以用继承以外的方式来处理复杂对象的不同配置。
 * - 原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其优点。
 * - 逃避构造函数的约束，这既是它的优点也是缺点，直接在内存中拷贝，构造函数是不会执行的。优点就是减少了约束，缺点也是减少了约束，需要大家在实际应用时考虑。
 * #缺点
 * - 克隆包含循环引用的复杂对象可能会非常麻烦。
 *
 * @使用场景
 * - 如果你需要复制一些对象，同时又希望代码独立于这些对象所属的具体类，可以使用原型模式。这一点考量通常出现在代码需要处理第三方代码通过接口
 *  传递过来的对象时。即使不考虑代码耦合的情况，你的代码也不能依赖这些对象所属的具体类，因为你不知道它们的具体信息。原型模式为客户端代码提供
 *  一个通用接口，客户端代码可通过这一接口与所有实现了克隆的对象进行交互，它也使得客户端代码与其所克隆的对象具体类独立开来。
 * - 如果子类的区别仅在于其对象的初始化方式，那么你可以使用该模式来减少子类的数量。别人创建这些子类的目的可能是为了创建特定类型的对象。在原型模式中，
 *  你可以使用一系列预生成的、各种类型的对象作为原型。客户端不必根据需求对子类进行实例化，只需找到合适的原型并对其进行克隆即可。
 * - 资源优化场景：类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。
 * - 性能和安全要求的场景：通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
 * - 一个对象多个修改者的场景：一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 *  在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法创建一个对象，然后由工厂方法提供给调用者。
 *  原型模式已经与Java融为一体，大家可以随手拿来使用。
 *
 * @思路
 * 与Java的实现方式有区别，思维方式可以借鉴。
 * - 创建原型接口， 并在其中声明 克隆方法。如果你已有类层次结构，则只需在其所有类中添加该方法即可。
 * - 原型类必须另行定义一个以该类对象为参数的构造函数。构造函数必须复制参数对象中的所有成员变量值到新建实体中。如果你需要修改子类，
 *  则必须调用父类构造函数， 让父类复制其私有成员变量值。
 * - 如果编程语言不支持方法重载，那么你可能需要定义一个特殊方法来复制对象数据。在构造函数中进行此类处理比较方便，因为它在调用
 *  new运算符后会马上返回结果对象。
 * - 克隆方法通常只有一行代码：使用 new运算符调用原型版本的构造函数。注意，每个类都必须显式重写克隆方法并使用自身类名调用 new运算符。
 *  否则，克隆方法可能会生成父类的对象。
 * - 你还可以创建一个中心化原型注册表，用于存储常用原型。
 * - 你可以新建一个工厂类来实现注册表，或者在原型基类中添加一个获取原型的静态方法。该方法必须能够根据客户端代码设定的条件进行搜索。
 *  搜索条件可以是简单的字符串，或者是一组复杂的搜索参数。找到合适的原型后，注册表应对原型进行克隆，并将复制生成的对象返回给客户端。
 * - 最后还要将对子类构造函数的直接调用替换为对原型注册表工厂方法的调用。
 */
public class PrototypeClient {
    /**
     * @分类
     * - 原型（Prototype）接口将对克隆方法进行声明。在绝大多数情况下，其中只会有一个名为 clone克隆的方法。Java中使用Cloneable接口和Object
     *  类的clone相结合的方式。
     * - 具体原型（Concrete Prototype）类将实现克隆方法。除了将原始对象的数据复制到克隆体中之外，该方法有时还需处理克隆过程中的极端情况，
     *  例如克隆关联对象和梳理递归依赖等等。Java中需要实现Cloneable接口并覆写clone方法，方法返回值为Object（即Object类的clone方法）。
     *  具体原型对象需要先创建，可以使用构造还是给对象的属性设值，这就是复制的蓝本。
     * - 客户端（Client）可以复制实现了原型接口的任何对象。先创建对象，然后可以使用clone方法复制对象。
     * @throws CloneNotSupportedException
     */
    @Test
    public void testExp01() throws CloneNotSupportedException {
        Phone phone = new Phone("HW", "星光色", "Mate 60");
        System.out.println("Test买了一台" + phone + phone.hashCode());
        Phone clone = (Phone) phone.clone();
        System.out.println("Test又买了一台" + clone + clone.hashCode());
    }

    /**
     * 浅copy
     * @throws CloneNotSupportedException
     */
    @Test
    public void testExp02() throws CloneNotSupportedException {
        Phone3 phone = new Phone3("HW", "星光色", "Mate 60", new Owner("test"));
        System.out.println("Test买了一台" + phone + phone.hashCode());
        Phone3 clone = (Phone3) phone.clone();
        System.out.println("Test又买了一台" + clone + clone.hashCode());
    }

    /**
     * 深copy
     * @throws CloneNotSupportedException
     */
    @Test
    public void testExp02_1() throws CloneNotSupportedException {
        Phone2 phone = new Phone2("HW", "星光色", "Mate 60", new Owner("test"));
        System.out.println("Test买了一台" + phone + phone.hashCode());
        Phone2 clone = (Phone2) phone.clone();
        System.out.println("Test又买了一台" + clone + clone.hashCode());
    }
}