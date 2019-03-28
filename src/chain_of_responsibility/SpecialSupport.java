package chain_of_responsibility;

/**
 * 只解决指定编号的问题
 * 
 * @author KANYUN
 *
 */
public class SpecialSupport extends Support {
	private int number;

	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method
		if (trouble.getNum() == number) {
			return true;
		}
		return false;
	}

}
