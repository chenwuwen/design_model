package flyweight;

/**
 * Main类（代码清单20-15）比较简单。它根据接收到的参数生成并显示Bigstring类的实例，仅此而已。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);

		}
		BigString bs = new BigString((args[0]));
		bs.print();
	}
}
