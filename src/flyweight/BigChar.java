package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Bigchar类(代码清单20-12)是表示“大型字符”的类。
 * 它的构造函数会生成接收到的字符所对应的“大型字符”版本的实例，并将其保存在fontdata字段中。
 * 我们将组成这些“大型字符”的数据(即字体数据)保存在文件中(代码清单20-1~代码清单20-11)。
 * 文件的命名规则是在该字体数据所代表的字符前加上“big”，文件后缀名是”.txt"。
 * 例如，3，对应的字体数据保存在“big3.txt”文件中。如果找不到某个字符对应的字体数据，就在该字符后面打上问号(？”)作为其字体数据。
 * 在该类中，没有出现关于Flyweight模式中“共享”的相关代码。关于控制共享的代码，请看代码清单20-13中的BigCharFactory类。
 * 
 * @author KANYUN
 *
 */
public class BigChar {

	/**
	 * 字符名字
	 */
	private char charName;
	/**
	 * 大型字符对应的字符串(由1#·\n’组成)
	 */
	private String fontdata;

	/**
	 * 构造函数
	 */
	public BigChar(char charName) {
		this.charName = charName;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("big" + charName + ".txt"));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buf.append(line);
				buf.append("\n");
				reader.close();
				this.fontdata = buf.toString();
			}
		} catch (IOException e) {
			this.fontdata = charName + "?";
		}
	}

	/**
	 * 显示大型字符
	 */
	public void print() {
		System.out.println(fontdata);

	}
}
