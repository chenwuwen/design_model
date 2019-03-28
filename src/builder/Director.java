package builder;

/**
 * Director类（代码清单7-2）使用Builder类中声明的方法来编写文档。
 * Director类的构造函数的参数是Bui1der类型的。但是实际上我们并不会将Builder类的实例作为参数传递给Director类。
 * 这是因为Builder类是抽象类，是无法生成其实例的。
 * 实际上传递给Director类的是Builder类的子类（即后面会讲到的TextBuilder类和HTMLBuilder类等）的实例。
 * 而正是这些Builder类的子类决定了编写出的文档的形式。
 * construct方法是编写文档的方法。调用这个方法后就会编写文档。
 * construct方法中所使用的方法都是在Builder类中声明的方法（construct的意思是“构建”）。
 * 
 * @author KANYUN
 *
 */
public class Director {
	private Builder builder;

	/**
	 * 因为接收的参数是Builder的子类，所以可以将其保存在builder字段中
	 * 
	 * @param builder
	 */
	public Director(Builder builder) {
		super();
		this.builder = builder;
	}

	public void construct() {
		builder.makeItems(new String[] { "上午好", "下午好", });
		builder.makeString("从早上到下午");
		builder.makeTitle("Greeting");

		builder.makeItems(new String[] { "晚上好", "晚安", "再见" });
		builder.makeString("晚上");

		builder.close();
	}
}
