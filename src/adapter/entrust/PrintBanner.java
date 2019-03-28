package adapter.entrust;
/**
 * 适配器类
 * 使用 委托 的适配器模式
 * 
 * 使用了字段属性
 * @author KANYUN
 *
 */
public class PrintBanner extends Print {
	private Banner banner;

	public PrintBanner(String msg) {
		super();
		this.banner = new Banner(msg);
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		banner.showWithAster();
	}

}
