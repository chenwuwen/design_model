package chain_of_responsibility;

/**
 * 该类解决奇数编号问题
 * 
 * @author KANYUN
 *
 */
public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method stub
		if (trouble.getNum() % 2 == 1) {
			return true;
		}
		return false;
	}

}
