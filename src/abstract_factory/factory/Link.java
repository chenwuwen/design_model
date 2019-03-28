package abstract_factory.factory;

/**
 * Link类（代码清单8-2）是抽象地表示HTML的超链接的类。
 * ur1字段中保存的是超链接所指向的地址。乍一看，在Link类中好像一个抽象方法都没有，但实际上并非如此。
 * 由于Link类中没有实现父类（Item类）的抽象方法（makeHTML），因此它也是抽象类。
 * 
 * @author KANYUN
 *
 */
public abstract class Link extends Item {
	protected String url;

	public Link(String caption, String url) {
		super(caption);
		this.url = url;
		// TODO Auto-generated constructor stub
	}

}
