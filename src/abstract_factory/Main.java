package abstract_factory;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Link;
import abstract_factory.factory.Page;
import abstract_factory.factory.Tray;

/**
 * 在理解了抽象的零件、产品、工厂的代码后，我们来看看Main类（代码清单8-6）的代码。
 *  Main类使用抽象工厂生产零件并将零件组装成产品。Main类中只引入了factory包，从这一点可以看出，该类并没有使用任何具体零件、产品和工厂。
 * 具体工厂的类名是通过命令行来指定的。例如，如果要使用listfactory包中的ListFactory类，可以在命令行中输入以下命令。
 * java Main listfactory.ListFactory
 * Main类会使用getFactory方法生成该参数（arg[0]）对应的工厂，并将其保存在factory变量中。
 * 之后，Main类会使用factory生成Link和Tray，然后将Link和Tray都放入Tray中，最后生成Page并将生成结果输出至文件。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreateFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}
		Factory factory = Factory.getFactory(args[0]);
		Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
		Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

		Link us_yahoo = factory.createLink("Yahoo！", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo！Japan", "http://www,yahoo.co.jp/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");

		Tray traynews = factory.createTray("日报");
		traynews.add(people);
		traynews.add(gmw);

		Tray trayyahoo = factory.createTray("Yahoo！");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		Tray traysearch = factory.createTray("检索引擎");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);

		Page page = factory.createPage("LinkPage", "杨文轩");
		page.add(traynews);
		page.add(traysearch);
		page.output();
	}
}
