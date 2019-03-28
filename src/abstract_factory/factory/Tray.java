package abstract_factory.factory;

import java.util.ArrayList;

/**
 * Tray类（代码清单8-3）表示的是一个含有多个Link类和Tray类的容器（Tray有托盘的意思。请想象成在托盘上放置着一个一个项目）。
 * Tray类使用add方法将Link类和Tray类集合在一起。为了表示集合的对象是“Link类和Tray类”，
 * 我们设置add方法的参数为Link类和Tray类的父类Item类。
 * 虽然Tray类也继承了Item类的抽象方法makeHTML，但它并没有实现该方法。因此，Tray类也是抽象类。
 * 
 * @author KANYUN
 *
 */
public abstract class Tray extends Item {
	protected ArrayList tray = new ArrayList<>();

	public Tray(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
	}

	public void add(Item item) {
		tray.add(item);
	}

}
