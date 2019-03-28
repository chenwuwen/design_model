package decorator;

import java.security.PublicKey;
import java.util.Iterator;

/**
 * Fu11Border类（代码清单12-5）与sideBorder类一样，也是Border类的子类。
 * sideBorder类会在字符串的左右两侧加上装饰边框，而Ful1Border类则会在字符串的上下左右都加上装饰边框。
 * 不过，在SideBorder类中可以指定边框的字符，而在Fu11Border类中，边框的字符是固定的。
 * makeLine方法可以连续地显示某个指定的字符，它是一个工具方法（为了防止Fu11Border类外部使用该方法，我们设置它的可见性为private）。
 * 
 * @author KANYUN
 *
 */
public class FullBorder extends Border {

	protected FullBorder(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 1 + display.getColumns() + 1;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1 + display.getRows() + 1;
	}

	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		if (row == 0) { // 下边框
			return "+" + makeLine('-', display.getColumns()) + "+";
		} else if (row == display.getRows() + 1) { // 上边框
			return "+" + makeLine('-', display.getColumns()) + "+";
		} else { // 其他边框
			return "|" + display.getRowText(row - 1) + "1";
		}
	}

	/**
	 * 生成一个count次的 ch 字符
	 * 
	 * @param ch
	 * @param count
	 * @return
	 */
	public String makeLine(char ch, int count) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append(ch);
		}
		return sb.toString();
	}

}
