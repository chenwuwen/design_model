package abstract_factory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Page类（代码清单8-4）是抽象地表示HTML页面的类。如果将Link和Tray比喻成抽象的
 * “零件”，那么Page类就是抽象的“产品”。
 * title和author分别是表示页面标题和页面作者的字段。作者名字通过参数传递给Page类的构造函数。
 * 可以使用add方法向页面中增加Item（即Link或Tray）。增加的Item将会在页面中显示出来。
 * output方法首先根据页面标题确定文件名，接着调用makeHTML方法将自身保存的HTML内容写入到文件中。
 * 其中，我们可以去掉如下语句（1）中的this，将其写为如下语句（2）那样。
 * writer.write（this.makeHTML（））；……（1）
 * writer.write（makeHTML（））；……（2）
 * 为了强调调用的是Page类自己的makeHTML方法，我们显式地加上了this。
 * 这里调用的makeHTML方法是一个抽象方法。output方法是一个简单的TemplateMethod模式的方法。
 * 
 * @author KANYUN
 *
 */
public abstract class Page {
	protected String title;
	protected String author;
	protected ArrayList content = new ArrayList<>();

	public Page(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public void add(Item item) {
		content.add(item);
	}

	public void output() {
		String filename = title + ".html";
		Writer writer;
		try {
			writer = new FileWriter(filename);
			writer.write(this.makeHtml());
			writer.close();
			System.out.println(filename + "编写完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public abstract String makeHtml();
}
