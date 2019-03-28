package decorator;

/**
 * SideBorder类（代码清单12-4）是一种具体的装饰边框，是Border类的子类。
 * sideBorder类用指定的字符（borderchar）装饰字符串的左右两侧。
 * 例如，如果指定borderchar字段的值是"|"，那么我们就可以调用show方法，像下面这样在“被装饰物”的两侧加上“|”。 | 被装饰物 |
 * 还可以通过构造函数指定borderchar字段。 sideBorder类并非抽象类，这是因为它实现了父类中声明的所有抽象方法。
 * getColumns方法是用于获取横向字符数的方法。字符数应当如何计算呢？非常简单，只需要在被装饰物的字符数的基础上，再加上两侧边框的字符数即可。
 * 那被装饰物的字符数应该如何计算呢？是的，大家应该都想到了，其实只需调用display.getColumns（）即可得到被装饰物的字符数。
 * display字段的可见性是protected，因此sideBorder类的子类都可以使用该字段。 然后我们再像下面这样，分别加上左右边框的字符数。
 * 1+display.getcolumns（）+1这就是getcolumns方法的返回值了。当然，写作display.getColumns（）+2也是可以的。
 * 只是在本书中，我们为了明确地表示是分别加上左右两侧边框的字符数1，所以采用了上面的表达式。
 * 在理解了getColumns方法的处理方式后，也就可以很快地理解
 * getRows方法的处理了。因为sideBorder类并不会在字符串的上下两侧添加字符，因此
 * getRows方法直接返回display.getRows（）即可。
 * 那么，getRowText方法应该如何实现呢？调用getRowText方法可以获取参数指定的那一行的字符数。
 * 因此，我们会像下面这样，在display.getRowText（row）的字符串两侧，
 * 加上borderchar这个装饰边框。 borderChar+ display.getRowrext（row）+borderChar
 * 这就是getRowText方法的返回值（也就是SideBorder的装饰效果）。
 * 
 * @author KANYUN
 *
 */
public class SideBorder extends Border {
	/**
	 * 表示装饰边框字符
	 */
	private char borderchar;

	/**
	 * 通过构造函数指定 Display 和装饰边框字符
	 * 
	 * @param display
	 * @param borderchar
	 */
	protected SideBorder(Display display, char borderchar) {
		super(display);
		// TODO Auto-generated constructor stub
		this.borderchar = borderchar;
	}

	/**
	 * 字符数为字符串字符数加上两侧边框字符数
	 */
	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 1 + display.getColumns() + 1;
	}

	/**
	 * 行数即为被装饰物的行数
	 */
	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return display.getRows();
	}

	/**
	 * 指定那一行的字符串为被装饰物的字符串 加上 两侧的边框的字符串
	 */
	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		return borderchar + display.getRowText(row) + borderchar;
	}

}
