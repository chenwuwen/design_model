package template_method;
/**
 * 抽象类,具体实现交由子类
 * @author KANYUN
 *
 */
public abstract class AbstractDisplay {
	public abstract void open();

	public abstract void print();

	public abstract void close();

	/**
	 * 这个方法应该就是模板方法
	 */
	public final void display() {
		open();
		for (int i = 0; i < 5; i++) {
			print();
		}
		close();
	};
}
