package bridge;

/**
 * Main类（代码清单9-5）将上述4个类组合起来显示字符串。虽然变量d1中保存的是Display类的实例，
 * 而变量d2和d3中保存的是CountDisplay类的实例，但它们内部都保存着stringDisplayImpl类的实例。
 * 由于d1、d2、d3都属于Display类的实例，因此我们可以调用它们的display方法。此外，我们还可以调用d3的maltipisplay方法
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hel1o, China."));
		Display d2 = new CountDisplay(new StringDisplayImpl("Rello, World,"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe,"));
		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);
	}
}
