package prototype;

/**
 * UnderlinePen类（代码清单6-4）的实现与MessageBox几乎完全相同，不同的是在ulchar字段中保存的是修饰下划线样式的字符。
 * use方法的作用是将字符串用双引号括起来显示，并在字符串下面加上下划线。
 * 
 * @author KANYUN
 *
 */
public class UnderlinePen implements Product {
	private char ulchar;

	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}

	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
		int len = s.getBytes().length;

		System.out.println("\"" + s + "\"");
		System.out.print(" ");
		for (int i = 0; i < len; i++) {
			System.out.print(ulchar);
		}
		System.out.println("");
	}

	@Override
	public Product createClone() {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product = (Product) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

}
