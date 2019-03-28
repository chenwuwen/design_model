package interpreter;

import java.util.StringTokenizer;

/**
 * 这里，我们使用java.uti1.Stringrokenizer类来简化了我们的程序， 它会将接收到的字符串分割为标记。
 * 在分割字符串时使用的分隔符是空格“”、制表符“\t，”、换行符“\n！”、回车符“·\r！”、换页符“\f，”（也可以使用其他分隔符，请根据需要查阅Java的APl文档）。
 * 
 * @author KANYUN
 *
 */
public class Context {
	private StringTokenizer tokenizer;
	private String currentToken;

	public Context(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
	}

	/**
	 * 获取下一个标记（前进至下一个标记）
	 * 
	 * @return
	 */
	public String nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}

	/**
	 * 获取当前的标记（不会前进至下一个标记）
	 * 
	 * @return
	 */
	public String currentToken() {
		return currentToken;
	}

	/**
	 * 先检查当前标记，然后获取下一个标记（前进至下一个标记）
	 * 
	 * @param token
	 * @throws ParseException
	 */
	public void skipToken(String token) throws ParseException {
		if (!token.equals(currentToken)) {
			throw new ParseException("Warning:" + token + "is expected, but " + currentToken + "is found.");
		}
		nextToken();
	}

	/**
	 * 获取当前标记对应的数值（不会前进至下一个标记）
	 * 
	 * @return
	 * @throws ParseException
	 */
	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warning:" + e);
		}
		return number;
	}
}