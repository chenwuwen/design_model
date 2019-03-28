package prototype;

import java.net.URLPermission;

public class Main {
	public static void main(String[] args) {
		// 准备
		Manager manager = new Manager();
		UnderlinePen underlinePen = new UnderlinePen('~');
		MessageBox box1 = new MessageBox('*');
		MessageBox box2 = new MessageBox('/');
		manager.register("strong message", underlinePen);
		manager.register("warning box", box1);
		manager.register("slash message", box2);
		// 生成
		Product p1 = manager.ctreate("strong message");
		Product p2 = manager.ctreate("warning box");
		Product p3 = manager.ctreate("slash message");
		p1.use("Hello,World!");
		p2.use("Hello,World!");
		p3.use("Hello,World!");

	}
}
