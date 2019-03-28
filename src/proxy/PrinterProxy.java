package proxy;

/**
 * PrinterProxy类（代码清单21-3）是扮演“代理人”角色的类，它实现了Printable接口。
 * name字段中保存了打印机的名字，而rea1字段中保存的是“本人”。 在构造函数中设置打印机的名字（此时还没有生成“本人”）。
 * setPrinterName方法用于设置新的打印机名字。如果rea1字段不为nu11（也就是已经生成了“本人”），那么会设置“本人”的名字。
 * 但是当rea1字段为nu11时（即还没有生成“本人”），那么只会设置自己（PrinterProxy的实例）的名字。
 * getPrinterName会返回自己的name字段。
 * print方法已经超出了代理人的工作范围，因此它会调用realize方法来生成本人。Realize有“实现”（使成为真的东西）的意思。
 * 在调用realize方法后，rea1字段中会保存本人（Print类的实例），因此可以调用real.print方法。这就是“委托”。
 * 不论setPrinterName 方法和getPrinterName方法被调用多少次，都不会生成Printer类的实例。
 * 只有当真正需要本人时，才会生成Printer类的实例（PrinterProxy类的调用者完全不知道是否生成了本人，也不用在意是否生成了本人）。
 * realize方法很简单，当real字段为nul1时，它会使用new Printer来生成Printer类的实例；如果rea1字段不为nul1（即已经生成了本人），则什么都不做。
 * 这里希望大家记住的是，Printer类并不知道PrinterProxy类的存在。即，Printer类并不知道自己到底是通过PrinterProxy被调用的还是直接被调用的。
 * 但反过来，PrinterProxy类是知道printer类的。这是因为PrinterProxy类的real字段是Printer类型的。
 * 在PrinterProxy类的代码中，显式地写出了Printer这个类名。
 * 因此，PrinterProxy类是与Printer类紧密地关联在一起的组件（关于它们之间的解耦方法，请参见习题21-1）。
 * 相信细心的读者应该已经发现了Printer类的setPrinterName方法和realize方法都是synchronized方法。我们会在习题21-2中讨论这样设计的原因。
 * 
 * @author KANYUN
 *
 */
public class PrinterProxy implements Printable {

	/**
	 * 名字
	 */
	private String name;
	/**
	 * 本人
	 */
	private Printer real;

	public PrinterProxy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrinterProxy(String name) {
		super();
		this.name = name;
	}

	@Override
	public void setPrinterName(String name) {
		// TODO Auto-generated method stub
		if (real != null) {
			// 同时设置本人名字
			real.setPrinterName(name);
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void print(String string) {
		// TODO Auto-generated method stub
		realize();
		real.print(string);
	}

	/**
	 * 生成“本人”
	 */
	private synchronized void realize() {
		if (real == null) {
			real = new Printer(name);
		}
	}
}
