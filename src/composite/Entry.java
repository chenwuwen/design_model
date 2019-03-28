package composite;

/**
 * Entry类(代码清单11-1)是一个表示目录条目的抽象类。Fi1e类和Directory类是它的子类。
 * 目录条目有一个名字，我们可以通过getName方法获取这个名字。getName方法的实现由子类负责。
 * 此外，目录条目还有一个大小。我们可以通过getsize方法获得这个大小。getsize方法的实现也由子类负责。
 * 向文件夹中放入文件和文件夹(即目录条目)的方法是add方法。不过实现这个add方法的是目录条目类的子类Directory类。
 * 在Entry类中，它只是简单地抛出异常而已。当然，add方法有多种实现方式，详细的讲解请参见本章11.4节。
 * printList方法用于显示文件夹中的内容的“一览”，它有两种形式，一种是不带参数的printList()，另一种是带参数的printList(String)。
 * 我们称这种定义方法的方式为重载(overload)。程序在运行时会根据传递的参数类型选择并执行合适的printList方法。
 * 这里，printList()的可见性是public，外部可以直接调用;而printList(String)的可见性是protected，只能被Entry类的子类调用。
 * tostring方法定义了实例的标准的文字显示方式。本例中的实现方式是将文件名和文件大小一起显示出来。getName
 * 和getsize都是抽象方法，需要子类去实现这些方法，以供tostring调用(即Template Method模式)。
 * 
 * @author KANYUN
 *
 */
public abstract class Entry {
	/**
	 * 获取名字
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * 获取大小
	 * 
	 * @return
	 */

	public abstract int getSize();

	/**
	 * 加入目录条目
	 * 
	 * @param entry
	 * @returnF
	 * @throws FileTreatmentException
	 */
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	/**
	 * 显示目录条目一览
	 */
	public void printList() {
		printList("");
	}

	/**
	 * 为一览加上前缀并显示目录条目一览
	 * 
	 * @param prefix
	 */
	protected abstract void printList(String prefix);

	/**
	 * 显示代表类的文字
	 * 
	 * @return
	 */
	public String tostring() {
		return getName() + "(" + getSize() + ")";
	}
}
