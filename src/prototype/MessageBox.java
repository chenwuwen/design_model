package prototype;

/**
 * MessageBox类（代码清单6-3）实现（implements）了Product接口。
 * decochar字段中保存的是像装饰方框那样的环绕着字符串的字符。use方法会使用decochar字段中保存的字符把要显示的字符串框起来。
 * createclone方法用于复制自己。它内部所调用的clone方法是Java语言中定义的方法，用于复制自己。
 * 在进行复制时，原来实例中的字段的值也会被复制到新的实例中。我们之所以可以调用c1one方法进行复制，
 * 仅仅是因为该类实现了ava.lang.Cloneable接口。如果没有实现这个接口，在运行时程序将会抛出CloneNotsupportedException异常，
 * 因此必须用try...catch语句块捕捉这个异常。虽然此处MessegeBox类只实现了Product接口，
 * 但是前文讲到过，Product接口继承了ava.lang.Cloneab1e接口，因此程序不会抛出CloneNotSupportedException异常。
 * 此外，需要注意的是，java.1ang.Cloneab1e接口只是起到告诉程序可以调用clone方法的作用，它自身并没有定义任何方法。
 * 只有类自己（或是它的子类）能够调用Java语言中定义的clone方法。当其他类要求复制实例时，必须先调用createclone这样的方法，
 * 然后在该方法内部再调用clone方法。
 * 
 * @author KANYUN
 *
 */
public class MessageBox implements Product {
	private char decochar;

	public MessageBox(char decochar) {
		this.decochar = decochar;
	}

	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
		int len = s.getBytes().length;
		for (int i = 0; i < len; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);
		for (int i = 0; i < len; i++) {
			System.out.print(decochar);
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
