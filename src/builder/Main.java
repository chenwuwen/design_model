package builder;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			usage();
			System.exit(0);
		}
		if (args[0].equals("plain")) {
			TextBuilder tb = new TextBuilder();
			Director director = new Director(tb);
			director.construct();
			String ret = tb.getResult();
			System.out.println(ret);
		} else if (args[0].equals("html")) {
			HtmlBuilder hb = new HtmlBuilder();
			Director director = new Director(hb);
			director.construct();
			String fileName = hb.getResult();
			System.out.println(fileName + "文件编写完成");
		} else {
			usage();
			System.exit(0);
		}
	}

	private static void usage() {
		// TODO Auto-generated method stub
		System.out.println("USAGE: java Main plain 编写纯文本文档");
		System.out.println("USAGE: java Main html 编写html文档");
	}
}
