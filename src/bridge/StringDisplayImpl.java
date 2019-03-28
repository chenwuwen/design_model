package bridge;

/**
 * 类的实现层次结构：
 * StringDisplaylmpl类下面我们来看看真正的“实现”。stringDisplayImp1类（代码清单9-4）是显示字符串的类。
 * 不过，它不是直接地显示字符串，而是继承了DisplayImp1类，作为其子类来使用rawopen、rawPrint、rawclose方法进行显示。
 * 
 * @author KANYUN
 *
 */
public class StringDisplayImpl extends DisplayImpl {
	/**
	 * 要显示的字符串
	 */
	private String msg;
	/**
	 * 以字节单位计算出的字符串的宽度
	 */
	private int width;

	/**
	 * 构造函数接收要显示的字符串
	 * 
	 * @param msg
	 */
	public StringDisplayImpl(String msg) {
		this.msg = msg;
		this.width = msg.getBytes().length;
	}

	@Override
	public void rawOpen() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void rawPrint() {
		// TODO Auto-generated method stub
		System.out.println("|" + msg + "|");
	}

	@Override
	public void rawClose() {
		// TODO Auto-generated method stub
		printLine();
	}

	private void printLine() {
		System.out.print("+");// 显示用来表示方框的角的“+”for（inti=0；i<width；i++）{//显示width个“-"
		for (int i = 0; i < width; i++) {
			System.out.print("-");// 将其用作方框的边框System.out.print1n（“+"）；//显示用来表示方框的角的“+
		}
		System.out.println("+");

	}
}
