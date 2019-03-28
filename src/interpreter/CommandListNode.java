package interpreter;

import java.util.ArrayList;
import java.util.List;

import interpreter.Context;
import interpreter.ParseException;;

/**
 * 下面我们来看看CommandListNode类（代码清单23-3）。<command 1ist>的BNF描述如下。
 * <command list>：：=<command>*end 即重复0次以上<command>，然后以end结束。
 * 为了能保存0次以上的<command>，我们定义了ava.util.Arraylist类型的字段1ist，在该字段中保存与<command>对应的CommandNode类的实例。
 * CommandListNode类的parse方法是怎么实现的呢？
 * 首先，如果当前的标记context.currentToken（）是nul1，表示后面没有任何标记（也就是已经解析至迷你程序的末尾）了。
 * 这时，parse方法会先设置ParseException异常中的消息为“缺少end（Missing'end.”)，然后抛出ParseException异常。
 * 接下来，如果当前的标记是end，表示已经解析至<command 1ist>的末尾。这时，parse方法会跳过end，然后break出while循环。·
 * 再接下来，如果当前的标记不是end，则表示当前标记是<command>。
 * 这时，parse方法会生成与<command>对应的commandNode的实例，并调用它的parse方法进行解析。
 * 然后，还会将commandNode的实例add至list字段中。 大家应该看出来了，这里的实现也没有超出BNF描述的范围。
 * 我们在编程时要尽量忠实于BNF描述，原封不动地将BNF描述转换为Java程序。 这样做可以降低出现Bug的可能性。
 * 在编程过程中，往往很容易受到“如果这样改一下可以提高程序效率吧”这样的诱惑，
 * 会不自觉地想在类中加入读取更深层次的节点的处理，但这样反而可能会引入意想不到的Bug。
 * Interpreter模式本来就采用了迷你语言这样的间接处理，所以耍一些小聪明来试图提高效率并不明智。
 * 
 * @author KANYUN
 *
 */
public class CommandListNode extends Node {
	private List list = new ArrayList<>();

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		while (true) {
			if (context.currentToken() == null) {
				throw new ParseException("Missing ' end'");
			} else if (context.currentToken().equals("end")) {
				context.skipToken("end");
				break;
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
		}

	}

	@Override
	public String toString() {
		return list.toString();
	}

}
