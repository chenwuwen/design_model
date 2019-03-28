package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Main类（代码清单23-9）是启动我们之前学习的迷你语言解释器的程序。
 * 它会读取program.txt文件，然后逐行解析迷你程序，并将解析结果显示出来。
 * 在显示结果中，以“text=”开头的部分是迷你程序语句，
 * 以“node=”开头的部分是语法解析结果。
 * 图23-11展示了示例程序的运行结果。
 * 通过查看运行结果我们可以发现，语法解释器识别出了program.end字符串中的迷你语言的语法元素，并为它们加上[]。这表示语法解释器正确地理解了我们定义的迷你语言。
 * 注意将CommandListNode的实例转换为字符串显示出来——例如在[go，right]中加上大括号和逗号一一的是java.util.ArrayList的toString方法。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
			String text;
			while ((text = reader.readLine()) != null) {
				System.out.println("text=\"" + text + "\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("node=" + node);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
