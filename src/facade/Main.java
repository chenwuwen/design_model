package facade;

/**
 * Main类（代码清单15-5）使用了pagemaker包中的PageMaker类，具体内容只有下面这一行。
 * PageMaker，makeWelcomePage（"hyukighyukl.com"，"welcome.html"）；
 * 它会获取hyukiehyuki.com的名字，然后编写出一个名为welcome.html的Web页面。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		PageMaker.makewelcomepage("看云", "welcome.html");
	}
}
