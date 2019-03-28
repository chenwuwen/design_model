package abstract_factory.listfactory;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Link;
import abstract_factory.factory.Page;
import abstract_factory.factory.Tray;

/**
 * 之前我们学习了抽象类的代码，现在让我们将视角切换到具体类。首先，我们来看看1istfactory包中的工厂—ListFactory类。
 * ListFactory类（代码清单8-7）实现了Factory类的createLink方法、createTray方法以及createPage方法。
 * 当然，各个方法内部只是分别简单地new出了ListLink类的实例、ListTray类的实例以及ListPage类的实例
 * （根据实际需求，这里可能需要用Prototype模式来进行clone）。
 * 
 * @author KANYUN
 *
 */
public class ListFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		// TODO Auto-generated method stub
		return new ListLink(caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		// TODO Auto-generated method stub
		return new ListTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO Auto-generated method stub
		return new ListPage(title, author);
	}

}
