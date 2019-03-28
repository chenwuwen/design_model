package interpreter;

import interpreter.Context;
import interpreter.Node;
import interpreter.ParseException;

/**
 * RepeatCommandNode类（代码清单23-5）对应<repeat command>的类。 <repeat command>的BNF描述如下。
 * <repeat command>::=repeat<number><command list>
 * 在代码中，<number>被保存在int型字段number中，<command 1ist>被保存在Node型字段commandListNode中。
 * 现在，大家应该都注意到parse方法的递归关系了。让我们追溯一下parse方法的调用关系。
 * ·在RepeatCommandNode类的parse方法中，会生成CommandListNode的实例，然后调用它的parse方法
 * ·在CommandListNode的parse方法中，会生成CommandNode的实例，然后调用它的parse方法
 * ·在CommandNode类的parse方法中，会生成RepeatcommandNode的实例，然后调用它的parse方法
 * ·在RepeatCommandNode类的 parse方法中…… 这样的parse方法调用到底要持续到什么时候呢？其实，它的终点就是终结符表达式。
 * 在CommandNode类的parse方法中，程序并不会一直进入if语句的RepeatCommandNode处理分支中，
 * 最终总是会进入PrimitiveCommandNode的处理分支。并且，不会从PrimitiveCommandNode的parse
 * 方法中再调用其他类的parse方法。关于这一点，稍后我们来学习。 如果不习惯递归定义的处理方式，可能会感觉到这里似乎进入了死循环。其实这是错觉。
 * 不论是在BNF描述中还是在Java程序中，一定都会结束于终结符表达式。如果没有结束于终结符表达式，那么一定是语法描述有问题。
 * 
 * @author KANYUN
 *
 */
public class RepeatCommandNode extends Node {

	private int number;
	private Node commandListNode;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	@Override
	public String toString() {
		return "[ repeat" + number + " " + commandListNode + "]";
	}

}
