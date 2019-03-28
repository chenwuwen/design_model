package interpreter;
import interpreter.Context;
import interpreter.ParseException;
import interpreter.Node;


/**
 * PrimitivecommandNode类（代码清单23-6）对应的BNF描述如下。 <primitive command>：：=go l right I
 * left确实，PrimitivecommandNode类的parse方法没有调用其他类的parse方法。
 * 
 * @author KANYUN
 *
 */
public class PrimitiveCommandNode extends Node {

	private String name;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		name = context.currentToken();
		context.skipToken(name);
		if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
			throw new ParseException(name + "is undefined");
		}
	}

	@Override
	public String toString() {
		return "PrimitiveCommandNode [name=" + name + "]";
	}


}
