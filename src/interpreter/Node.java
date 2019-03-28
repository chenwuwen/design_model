package interpreter;

import interpreter.Context;
import interpreter.ParseException;

/**
 * Node类（代码清单23-l）是语法树中各个部分（节点）中的最顶层的类。 在Node类中只声明了一个parse抽象方法，该方法用于“进行语法解析处理”。
 * 但Node类仅仅是声明该方法，具体怎么解析交由Node类的子类负责。
 * parse方法接收到的参数Context是表示语法解析上下文的类，稍后我们将来学习parse方法。
 * 在parse的声明中，我们使用了throws关键字。它表示在语法解析过程中如果发生了错误，parse方法就会抛出ParseException异常。
 * 如果只看Node类，我们还无法知道具体怎么进行语法解析，所以我们接着往下看。
 * 
 * @author KANYUN
 *
 */
public abstract class Node {
	public abstract void parse(Context context) throws ParseException;
}
