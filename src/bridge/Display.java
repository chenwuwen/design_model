package bridge;

/**
 * Display类（代码清单9-1）的功能是抽象的，负责“显示一些东西”。该类位于“类的功能层次结构”的最上层。
 * 在imp1字段中保存的是实现了Disp1ay类的具体功能的实例（impl是implementation（实现）的缩写）。
 * 该实例通过Display类的构造函数被传递给Display类，然后保存在imp1字段中，以供后面的处理使用（imp1字段即是类的两个层次结构的“桥梁”）。
 * open、print、close这3个方法是Display类提供的接口（API），它们表示“显示的步骤”。 
 * ·open是显示前的处理·print是显示处理 ·close是显示后的处理
 * 请注意这3个方法的实现，这3个方法都调用了imp1字段的实现方法。这样，Display的接口（API）就被转换成为了DisplayImp1的接口（APl）。
 * display方法调用open、print、close这3个Display类的接口（APl）进行了“显示”处理。
 * 
 * @author KANYUN
 *
 */
public class Display {
	private DisplayImpl impl;

	public Display(DisplayImpl impl) {
		super();
		this.impl = impl;
	}

	public void open() {
		impl.rawOpen();
	}

	public void print() {
		impl.rawPrint();
	}

	public void close() {
		// TODO Auto-generated method stub
		impl.rawClose();
	}

	public final void display() {
		// TODO Auto-generated method stub
		open();
		print();
		close();
	}
}
