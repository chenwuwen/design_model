package prototype;

/**
 * 该类继承了Cloneable接口，实现该接口的实例可以调用clone()方法来自动复制
 * 
 * @author KANYUN
 *
 */
public interface Product extends Cloneable {

	/**
	 * 该方法是抽象方法，具体如何实现交由子类完成
	 */
	public abstract void use(String s);

	/**
	 * 用于复制实例的方法
	 * 
	 * @return
	 */
	public abstract Product createClone();
}
