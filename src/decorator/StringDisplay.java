package decorator;

import decorator.Display;

/**
 * 仅查看Display类的代码是不能明白程序究竟要做什么的。下面我们来看看它的子类一StringDisplay类。
 * stringDisplay类（代码清单12-2）是用于显示单行字符串的类。
 * 由于stringDisplay类是Display类的子类，因此它肩负着实现Display类中声明的抽象方法的重任。
 * msg字段中保存的是要显示的字符串。由于stringDisplay类只显示一行字符串，
 * 因getcolumns方法返回string.getBytes（）.length的值，getRows方法则返回固定值1。
 * 此外，仅当要获取第0行的内容时getRowText方法才会返回string字段。
 * 以本章开头蛋糕的比喻来说，stringDisplay类就相当于生日蛋糕中的核心蛋糕。
 * 
 * @author KANYUN
 *
 */
public class StringDisplay extends Display {
	/**
	 * 要显示的字符串
	 */
	private String msg;

	/**
	 * 通过参数传入要显示的字符串
	 * 
	 * @param msg
	 */
	public StringDisplay(String msg) {
		super();
		this.msg = msg;
	}

	/**
	 * 返回列数
	 */
	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return msg.getBytes().length;
	}

	/**
	 * 行数是 1
	 */
	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * 仅当row为0时，返回值
	 */
	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		if (row == 0) {
			return msg;
		}
		return null;
	}

}
