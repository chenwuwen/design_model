package abstract_factory.listfactory;

import java.nio.Buffer;

import abstract_factory.factory.Item;
import abstract_factory.factory.Tray;
import iterator.Iterator;

/**
 * ListTray类（代码清单8-9）是Tray类的子类。这里我们重点看一下makeHTML方法是如何实现的。
 * tray字段中保存了所有需要以HTML格式输出的Item，而负责将它们以HTML格式输出的就是makeHTML方法了。那么该方法究竟是如何实现的呢？
 * makeHTML方法首先使用<1i>标签输出标题（caption），接着使用<u1>和<1i>标签输出每个Item。
 * 输出的结果先暂时保存在StringBuffer中，最后再通过tostring方法将输出结果转换为String类型并返回给调用者。
 * 那么，每个Item又是如何输出为HTML格式的呢？当然就是调用每个Item的makeHTML方法了。
 * 请注意，这里并不关心变量item中保存的实例究竟是ListLink的实例还是ListTray的实例，只是简单地调用了item.makeHTML（）语句而已。
 * 这里不能使用switch语句或if语句去判断变量item中保存的实例的类型，否则就是非面向对象编程了。
 * 变量item是Item类型的，而Item类又声明了makeHTML方法，而且ListLink类和ListTray类都是Item类的子类，因此可以放心地调用。
 * 之后item会帮我们进行处理。至于item究竟进行了什么样的处理，只有item的实例（对象）才知道。这就是面向对象的优点。
 * 这里使用的java.uti1.Iterator类与我们在Iterator模式一章中所学习的迭代器在功能上是相同的，不过它是Java类库中自带的。
 * 为了从java.util.ArrayList类中得到java.util.Iterator，我们调用iterator方法。
 * 
 * @author KANYUN
 *
 */
public class ListTray extends Tray {

	public ListTray(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeHtml() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<li>\n");
		sb.append(caption + "\n");
		sb.append("<ul>\n");
		java.util.Iterator iterator = tray.iterator();
		while (iterator.hasNext()) {
			Item item = (Item) iterator.next();
			sb.append(item.makeHtml());
		}
		sb.append("</ul>\n");
		sb.append("</li>\n");
		return sb.toString();
	}

}
