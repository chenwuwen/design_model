package abstract_factory.listfactory;

import abstract_factory.factory.Link;

/**
 * ListLink类（代码清单8-8）是Link类的子类。在ListLink类中必须实现的方法是哪个呢？
 * 对了，就是在父类中声明的makeHTML抽象方法。ListLink类使用<1i>标签和<a>标签来制作HTML片段。
 * 这段HTML片段也可以与ListTary和ListPag的结果合并起来，就如同将螺栓和螺母拧在一起一样。
 * 
 * @author KANYUN
 *
 */
public class ListLink extends Link {

	public ListLink(String caption, String url) {
		super(caption, url);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeHtml() {
		// TODO Auto-generated method stub
		return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
	}

}
