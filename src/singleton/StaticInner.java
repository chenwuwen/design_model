package singleton;

/**
 * 静态类内部加载 使用内部类的好处是，静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载，
 * 达到了类似懒汉模式的效果，而这种方法又是线程安全的。
 * 
 * @author KANYUN
 *
 */
public class StaticInner {
	private static class SingletonHolder {
		private static StaticInner instance = new StaticInner();
	}

	private StaticInner() {

	}

	public StaticInner getInstance() {
		return SingletonHolder.instance;
	}

}
