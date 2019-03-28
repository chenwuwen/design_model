package interpreter;

/**
 * ParseException类（代码清单23-7）是表示语法解析时可能发生的异常的类。该类比较简单，没有什么需要特别注意的地方。
 * 
 * @author KANYUN
 *
 */
public class ParseException extends Exception {
	public ParseException(String msg) {
		super(msg);
	}
}
