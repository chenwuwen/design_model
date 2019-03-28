package interpreter;

import interpreter.Node;
import interpreter.ParseException;
import interpreter.Context;

/**
 * 下面我们按照图23-8中展示的迷你语言的语法描述（BNF）来看看各个类的定义。
 * 首先，我们看看表示程序<program>的ProgramNode类（代码清单23-2）。
 * 在ProgramNode类中定义了一个Node类型的CommandListNode字段，该字段用于保存<commandlist>对应的结构（节点）。
 * 那么，ProgramNode的parse方法究竟进行了什么处理呢？ 通过查看迷你语言的BNF描述我们可以发现，
 * <program>的定义中最开始会出现program这个单词。因此，我们用下面的语句跳过这个单词。
 * context.skipToken（"program"）； 我们称语法解析时的处理单位为标记（token）。在迷你语言中，“标记”相当于“英文单词”。
 * 在一般的编程语言中，“+”和“=”等也是标记。更具体地说，词法分析（lex）是从文字中得到标记，而语法解析（parse）则是根据标记推导出语法树。
 * 上面的skipToken方法可以跳过program这个标记。如果没有这个标记就会抛出ParseException异常。
 * 继续查看BNF描述会发现，在program后面会跟着<command 1ist>。 这里，我们会生成 <command
 * 1ist>对应的CommandListNode类的实例，然后调用该实例的parse方法。 请注意，ProgranNode类的方法并不知道<command
 * list>的内容。 即在ProgramNode类中实现的内容，并没有超出下面的BNF所描述的范围。 <program>：：-program
 * <command list> toString方法用于生成表示该节点的字符串。
 * 在Java中，连接实例与字符串时会自动调用实例的tostring方法，因此如下（1）与（2）是等价的。
 * "[program"+commandListNode+“]"；……（1）
 * "tprogram"+commandListNode.toString（）+"]"；……（2）
 * 请注意，tostring方法的实现也与上面的BNF描述完全相符。
 * 
 * @author KANYUN
 *
 */
public class ProgramNode extends Node {
	private Node commandListNode;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		context.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(context);

	}

	@Override
	public String toString() {
		return " [Program" + commandListNode + "]";
	}

}
