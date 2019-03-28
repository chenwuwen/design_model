package iterator;

/**
 * 遍历集合的接口，用于遍历集合中的元素
 * 
 * @author KANYUN
 *
 */
public interface Iterator {
	/**
	 * 当集合中存在下一个元素时，返回true否则返回false，该方法的作用是作为终止循环条件
	 * @return
	 */
	public abstract boolean hasNext();
	
	/**
	 * 该方法返回集合中的一个元素，但其作用并非仅限于此，该方法还隐含着将迭代器移动至下一个元素的处理
	 * @return
	 */
	public abstract Object next();
}
