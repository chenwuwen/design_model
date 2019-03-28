package abstract_factory.factory;

/**
 * Item类（代码清单8-1）是Link类和Tray类的父类（ltem有“项目”的意思）。这样，Link类和Tray类就具有可替换性了。 。
 * 
 * @author KANYUN
 *
 */
public abstract class Item {
	/**
	 * caption字段表示项目的“标题”
	 */
	protected String caption;

	public Item(String caption) {
		super();
		this.caption = caption;
	}

	/**
	 * makeHTML方法是抽象方法，需要子类来实现这个方法。该方法会返回HTML文件的内容（需要子类去实现）。
	 * 
	 * @return
	 */
	public abstract String makeHtml();

}
