package decorator;

/**
 * Main类（代码清单12-6）是用于测试程序行为的类。
 * 在Main类中一共生成了4个实例，即b1~b4，它们的作用分别如下所示。
 * ·b1：将“He11o，world.·不加装饰地直接显示出来 
 * ·b2：在b1的两侧加上装饰边框，#，
 * ·b3：在b2的上下左右加上装饰边框
 * ·b4：为“你好，世界。”加上多重边框
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		Display bl = new StringDisplay("Hello,world.");
		Display b2 = new SideBorder(bl, '#');
		Display b3 = new FullBorder(b2);
		bl.show();
		System.out.println("");
		b2.show();
		System.out.println("");
		b3.show();
		System.out.println("");
		Display b4 = new SideBorder(
				new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("你好,世界!")), '*'))), '/');
		b4.show();
	}
}
