package builder;

/**
 * Builder类（代码清单7-1）是一个声明了编写文档的方法的抽象类。
 * makeTitle、makeString、makeTimes方法分别是编写标题、字符串、条目的方法。close方法是完成文档编写的方法。
 * 
 * @author KANYUN
 *
 */
public abstract class Builder {
	public abstract void makeTitle(String title);

	public abstract void makeString(String str);

	public abstract void makeItems(String[] items);

	public abstract void close();
}
