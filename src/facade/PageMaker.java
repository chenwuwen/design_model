package facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * PageMaker类(代码清单15-4)使用Database类和Htmlwriter类来生成指定用户的Web页面。
 * 在该类中定义的方法只有一个，那就是public的makewelcomePage方法。该方法会根据指定的邮件地址和文件名生成相应的Web页面。
 * PageMaker类一手包办了调用HtmlWriter类的方法这一工作。对外部，它只提供了makeWelcomePage接口。这就是一个简单窗口。
 * 
 * @author KANYUN
 *
 */
public class PageMaker {
	/**
	 * 防止外部 new出PageMaker的实例，所以声明为private方法
	 */
	private PageMaker() {

	}

	public static void makewelcomepage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to" + username + "'s page！");
			writer.paragraph(username + "欢迎来到" + username + "的主页。");
			writer.paragraph("等着你的邮件哦！");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + "is created for" + mailaddr + "(" + username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
