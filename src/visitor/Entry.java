package visitor;

import java.util.Iterator;

/**
 * 虽然Entry类(代码清单13-3)在本质上与Composite模式(第11章)中的Entry类是一样的，
 * 不过本章中的Entry类实现(implements)了Element接口。这是为了让Entry类适用于Visitor模式。
 * 实际上实现Element接口中声明的抽象方法accept的是Entry类的子类—File类和Directory类。
 * add方法仅对Directory类有效，因此在Entry类中，我们让它简单地报错。
 * 同样地，用于获取Iterator的iterator方法也仅对Directory类有效，我们也让它简单地报错。
 * 
 * @author KANYUN
 *
 */
public abstract class Entry implements Element {

	/**
	 * 获取名子
	 * @return
	 */
	public abstract String getName();

	/**
	 * 获取大小
	 * @return
	 */
	public abstract int getSize(); 

	/**
	 * 增加目录条目
	 * @param entry
	 * @return
	 * @throws FileTreatmentException
	 */
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	/**
	 * 生成Iterator
	 * @return
	 * @throws FileTreatmentException
	 */
	public Iterator iterator() throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	/**
	 * 显示字符串
	 * 
	 * @return
	 */
	public String tostring() {
		return getName() + "(" + getSize() + ")";
	}

}
