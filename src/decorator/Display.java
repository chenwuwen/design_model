package decorator;

/**
 * Display类（代码清单12-1）是可以显示多行字符串的抽象类。
 * getcolumns方法和getRows方法分别用于获取横向字符数和纵向行数。它们都是抽象方法，需要子类去实现。
 * getRowText方法用于获取指定的某一行的字符串。它也是抽象方法，需要子类去实现。
 * show是显示所有行的字符串的方法。在show方法内部，程序会调用getRows方法获取行数，调用getRowText获取该行需要显示的字符串，
 * 然后通过for循环语句将所有的字符串显示出来。show方法使用了getRows和getRowText等抽象方法，这属于Tempate
 * Method模式（第3章）。
 * 
 * @author KANYUN
 *
 */
public abstract class Display {
	/**
	 * 获取横问字行数
	 * 
	 * @return
	 */
	public abstract int getColumns();

	/**
	 * 获取纵向行数
	 * 
	 * @return
	 */
	public abstract int getRows();

	/**
	 * 获取第row行的字符串
	 * 
	 * @param row
	 * @return
	 */
	public abstract String getRowText(int row);

	/**
	 * 全部显示
	 */
	public final void show() {
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));

		}
	}
}
