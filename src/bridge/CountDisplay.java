package bridge;

import java.io.Closeable;

/**
 * 接下来，我们继续看“类的功能层次结构”。
 * CountDisplay类（代码清单9-2）在Display类的基础上增加了一个新功能。
 * Display类只具有“显示”的功能，CountDisplay类则具有“只显示规定的次数”的功能，这就是multipisplay方法。
 * CountDisplay类继承了Display类的open、print、close方法，并使用它们来增加这个新功能。 这就是“类的功能层次结构”。
 * 
 * @author KANYUN
 *
 */
public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 循环显示time次
	 * 
	 * @param times
	 */
	public void multiDisplay(int times) {
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}

}
