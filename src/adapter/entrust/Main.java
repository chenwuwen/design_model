package adapter.entrust;
/**
 * 使用委托的适配器模式
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		Print print = new PrintBanner("Hello");
		print.printStrong();
		print.printWeak();
	}
}
