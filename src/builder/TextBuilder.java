package builder;

import java.nio.Buffer;

/**
 * TextBuilder类（代码清单7-3）是Builder类的子类，它的功能是使用纯文本编写文档，并以String返回结果。
 * 
 * @author KANYUN
 *
 */
public class TextBuilder extends Builder {
	/**
	 * 文档内容保存在该字段中
	 */
	private StringBuffer sb = new StringBuffer();

	@Override
	public void makeTitle(String title) {
		// TODO Auto-generated method stub
		sb.append("================\n");
		sb.append("<" + title + ">");
		sb.append("/n");

	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		sb.append("*" + str + "\n");
		sb.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.length; i++) {
			sb.append("  ." + items[i] + "\n");
		}
		sb.append("\n");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		sb.append("=============\n");
	}

	public String getResult() {
		return sb.toString();
	}

}
