package chain_of_responsibility;

/**
 * NoSupport类（代码清单14-3）是Support类的子类。NoSupport类的resolve方法总是返回false。即它是一个永远“不解决问题”的类。
 * 
 * @author KANYUN
 *
 */
public class NoSupport extends Support {


	public NoSupport(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 解决问题的方法，什么也不处理
	 */
	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method stub
		return false;
	}

}
