package template_method;

/**
 * 另一个实现的子类
 * 
 * @author KANYUN
 *
 */
public class StringDisplay extends AbstractDisplay {
	private String msg;
	private int width;

	public StringDisplay(String msg) {
		super();
		this.msg = msg;
		this.width = msg.getBytes().length;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("|" + msg + "|");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		printLine();
	}

	private void printLine() {
		System.out.print("+");

		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

}
