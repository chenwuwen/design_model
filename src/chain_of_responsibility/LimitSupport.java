package chain_of_responsibility;

/**
 * LimitSupport类（代码清单14-4）解决编号小于limit值的问题。
 * resolve方法在判断编号小于limit值后，只是简单地返回true，但实际上这里应该是解决问题的代码。
 * 
 * @author KANYUN
 *
 */
public class LimitSupport extends Support {
	/**
	 * 可以解决编号小于limit的问题
	 */
	private int limit;

	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 解决问题的方法
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method stub
		if (trouble.getNum() < limit) {
			return true;
		}
		return false;
	}

}
