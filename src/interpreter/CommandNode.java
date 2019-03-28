package interpreter;

import interpreter.Context;
import interpreter.ParseException;
import interpreter.PrimitiveCommandNode;

/**
 * 如果大家理解了前面学习的ProgramNode类和CommandListNode类，那么应该也可以很快地理解CommandNode类（代码清单23-4）。
 * <command>的BNF描述如下。
 * <command>：：=<repeat command>I <primitive command>
 * 在代码中的Node类型的node字段中保存的是与<repeat command>对应的RepeatCommandNode
 * 类的实例，或与<primitive command>对应的PrimitiveCommandNode类的实例。
 * 
 * @author KANYUN
 *
 */
public class CommandNode extends Node {

	private Node node;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		if (context.currentToken().equals("repeat")) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}

	@Override
	public String toString() {
		return node.toString();
	}
}
