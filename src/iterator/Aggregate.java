package iterator;

/**
 * 表示集合的接口
 * 
 * @author KANYUN
 *
 */
public interface Aggregate {
	/**
	 * 该接口声明的只有这一个方法，该方法会生成一个用于遍历集合的迭代器
	 * @return
	 */
	public abstract Iterator iterator();
}
