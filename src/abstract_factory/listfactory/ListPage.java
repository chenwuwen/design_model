package abstract_factory.listfactory;

import java.util.Iterator;

import abstract_factory.factory.Item;
import abstract_factory.factory.Page;

/**
 * ListPage类（代码清单8-10）是Page类的子类。关于makeHTML方法，大家应该已经明白了吧。
 * ListPage将字段中保存的内容输出为HTML格式。作者名（author）用<address>标签输出。
 * 大家知道为什么while语句被夹在<u1>.</u1>之间吗？
 * 这是因为在while语句中append的item.makeHTML（）的输出结果需要被嵌入在<u1>..</u1>之间的缘故。
 * 请大家再回顾一下ListLink和ListTray的makeHTML（）方法，在它们的最外侧都会有<1i>标签，就像是“螺栓”和“螺母”的接头一样。
 * while语句的上一条语句中的content继承自Page类的字段。
 * 
 * @author KANYUN
 *
 */
public class ListPage extends Page {

	public ListPage(String title, String author) {
		super(title, author);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeHtml() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<html><head><title>" + title + "</title></head>\n");
		sb.append("<body>\n");
		sb.append("<h1>" + title + "</h1>\n");
		sb.append("<ul>\n");
		Iterator iterator = content.iterator();
		while (iterator.hasNext()) {
			Item item = (Item) iterator.next();
			sb.append(item.makeHtml());
		}
		sb.append("</ul>\n");
		sb.append("<hr><address>" + author + "</address>");

		sb.append("</body></html>\n");
		return sb.toString();
	}

}
