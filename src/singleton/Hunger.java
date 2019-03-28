package singleton;

/**
 * 饿汉模式 饿汉法就是在第一次引用该类的时候就创建对象实例，而不管实际是否需要创建
 * 这样做的好处是编写简单，但是无法做到延迟创建对象。但是我们很多时候都希望对象可以尽可能地延迟加载，从而减小负载，所以就需要下面的懒汉法
 * 
 * @author KANYUN
 *
 */
public class Hunger {
	private static Hunger hunger = new Hunger();

	private Hunger() {

	}

	/**
	 * 这里必须使用static方法是因为,由于单例模式（私有构造方法）,外部不能用new生成实例来调用类中的实例方法,故而此处只能使用static来修饰方法
	 * 
	 * @return
	 */
	public static Hunger getInstance() {
		return hunger;
	}
}
