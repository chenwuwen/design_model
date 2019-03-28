package adapter.extend;
/**
 * 使用继承 的适配器模式
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
