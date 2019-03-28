package facade;

import java.io.IOException;
import java.io.Writer;

/**
 * HtmlWriter类(代码清单15-3)用于编写简单的Web页面。我们在生成HtmlWriter类的实例时赋予其Writer,
 * 然后使用该Writer输出HTML。 tit1e方法用于输出标题; paragraph方法用于输出段落; 1ink方法用于输出超链接;
 * mailto方法用于输出邮件地址链接; close方法用于结束HTML的输出。 该类中隐藏着一个限制条件,那就是必须首先调用tit1e方法。
 * 窗口类Pagewaker使用HtmlWriter类时必须严格遵守这个限制条件。
 * 
 * @author KANYUN
 *
 */
public class HtmlWriter {
	private Writer writer;

	/**
	 * 构造函数
	 * 
	 * @param writer
	 */
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}

	/**
	 * 输出标题
	 * 
	 * @param title
	 * @throws IoException
	 */
	public void title(String title) throws IOException {
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</hl>\n");
	}

	/**
	 * 输出段落
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void paragraph(String msg) throws IOException {
		writer.write("<p>" + msg + "</p>\n");
	}

	/**
	 * 输出超链接
	 * @param href
	 */
	public void link(String href,String caption)throws IOException{
		paragraph("<a href=\""+href+"\">"+caption+"</a>");
	}

	/**
	 * 输出邮件地址
	 * 
	 * @param mailaddr
	 * @param username
	 * @throws IOException
	 */
	public void mailto(String mailaddr, String username) throws IOException {
		link("mailto:" + mailaddr, username);
	}

	/**
	 * 结束输出HTML
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
}
