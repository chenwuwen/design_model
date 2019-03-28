package proxy;

/**
 * Printer类（代码清单21-1）是表示“本人”的类。
 * 在之前的学习中我们也了解到了，在它的构造函数中，我们让它做一些所谓的“重活”（heavyJob）。 setPrinterName方法用于设置打印机的名字；
 * getPrinterName用于获取打印机的名字。
 * print方法则用于显示带一串打印机名字的文字。
 * heavyJob是一个干5秒钟“重活”的方法，它每秒（1000毫秒）以点号（.）显示一次干活的进度。
 * Proxy模式的核心是PrinterProxy类。Printer类自身并不难理解。
 * 
 * @author KANYUN
 *
 */
public class Printer implements Printable {
	private String name;

	public Printer() {
		// TODO Auto-generated constructor stub
		heavyJob("正在生成Printer实例");
	}

	public Printer(String name) {
		super();
		this.name = name;
		heavyJob("正在生成Printer实例(" + name + ")");
	}

	/**
	 * 设置名字
	 */
	@Override
	public void setPrinterName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	/**
	 * 获取名字
	 */
	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * 显示带打印机名字的文字
	 */
	@Override
	public void print(String string) {
		// TODO Auto-generated method stub
		System.out.println("========" + name + "=============");
		System.out.println(string);

	}

	/**
	 * 重活
	 * 
	 * @param msg
	 */
	private void heavyJob(String msg) {
		System.out.print(msg);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.print(".");
			}

		}
		System.out.println("结束");
	}
}
