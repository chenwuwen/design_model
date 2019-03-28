package singleton;
/**
 * 懒汉模式
 * 
 * @author KANYUN
 *
 */
public class Lazy {
	private static volatile Lazy instance = null;

	private Lazy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 这里必须使用static方法是因为,由于单例模式（私有构造方法）,外部不能用new生成实例来调用类中的实例方法,故而此处只能使用static来修饰方法
	 * 
	 * @return
	 */
	public static Lazy getInstance() {
		synchronized (Lazy.class) {
			if (instance == null) {
				instance = new Lazy();
			}
		}
		return instance;
	}
}
