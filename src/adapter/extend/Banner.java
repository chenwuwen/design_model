package adapter.extend;
/**
 * 现在的实际情况
 * @author KANYUN
 *
 */
public class Banner {
	private String msg;

	public Banner(String msg) {
		super();
		this.msg = msg;
	}

	public void showWithParen() {
		System.out.println("(" + msg + ")");
	}

	public void showWithAster() {
		System.out.println("*" + msg + "*");
	}
}
