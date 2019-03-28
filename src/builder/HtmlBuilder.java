package builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HTMLBuilder类（代码清单7-4）也是Builder类的子类，它的功能是使用HTML编写文档，其返回结果是HTML文件的名字。
 * 
 * @author KANYUN
 *
 */
public class HtmlBuilder extends Builder {
	/**
	 * 保存html文件的文件名
	 */
	private String fileName;
	private PrintWriter pw;

	@Override
	public void makeTitle(String title) {
		// TODO Auto-generated method stub
		fileName = title + ".html";
		try {
			pw = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<html><head><title>" + title + "</title></head></body>");
		pw.println("<h1>" + title + "</h1>");
	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		pw.println("<p>" + str + "</p>");
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		pw.println("<ul>");
		for (int i = 0; i < items.length; i++) {
			pw.println("<li>" + items[i] + "</li>");
		}
		pw.println("</ul>");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		pw.println("</body></html>");
		pw.close();
	}

	public String getResult() {
		return fileName;
	}

}
