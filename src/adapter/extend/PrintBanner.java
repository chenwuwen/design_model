package adapter.extend;
/**
 * 该类扮演了适配器的角色，其继承了Banner类，并继承其两个方法
 * 同时它又实现了Print接口，实现了它的两个方法
 * @author KANYUN
 *
 */
public class PrintBanner extends Banner implements Print {

	public PrintBanner(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		showWithAster();
	}

}
