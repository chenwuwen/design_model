package chain_of_responsibility;

/**
 * Troub1e类（代码清单14-1）是表示发生的问题的类。number是问题编号。通过getNumber法可以获取问题编号。
 * 
 * @author KANYUN
 *
 */
public class Trouble {
	/**
	 * 问题编号
	 */
	private int num;

	/**
	 * 生成问题
	 * 
	 * @param num
	 */
	public Trouble(int num) {
		super();
		this.num = num;
	}

	/**
	 * 获取问题编号
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "Trouble [num=" + num + "]";
	}

}
