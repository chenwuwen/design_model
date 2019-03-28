package visitor;

import java.util.Iterator;

/**
 * ListVisitor类（代码清单13-6）是Visitor类的子类，
 * 它的作用是访问数据结构并显示元素一览。因为ListVisitor类是Visitor类的子类，
 * 所以它实现了visit（File）方法和visit（Directory）方法。
 * currentdir字段中保存的是现在正在访问的文件夹名字。
 * visit（File）方法在访问者访问文件时会被Fi1e类的accept方法调用，参数file是所访问的Fi1e类的实例。
 * 也就是说，visit（File）方法是用来实现“对File类的实例要进行的处理”的。
 * 在本例中，我们实现的处理是先显示当前文件夹的名字（currentdir），然后显示间隔符号/"，最后显示文件名。
 * visit（Directory）方法在访问者访问文件夹时会被Directory类的accept方法调用，参数directory是所访问的Directory类的实例。
 * 在visit（Directory）方法中实现了“对Directory类的实例要进行的处理”。本例中我们是如何实现的呢？
 * 与visit（File）方法一样，我们先显示当前文件夹的名字，接着调用iterator方法获取文件夹的Iterator，
 * 然后通过Iterator遍历文件夹中的所有目录条目并调用它们各自的accept方法。由于文件夹中可能存在着许多目录条目，逐一访问会非常困难。
 * accept方法调用visit方法，visit方法又会调用accept方法，这样就形成了非常复杂的递归调用。
 * 通常的递归调用是某个方法调用自身，在Visitor模式中，则是accept方法与visit方法之间相互递归调用。
 * 
 * @author KANYUN
 *
 */
public class ListVisitor extends Visitor {
	/**
	 * 当前访问的文件夹的名字
	 */
	private String currentdir="";

	/**
	 * 在访问文件时调用
	 */
	@Override
	public void visit(File file) {
		// TODO Auto-generated method stub
		System.out.println(currentdir + "/" + file);
	}

	/**
	 * 在访问文件夹时调用
	 */
	@Override
	public void visit(Directory directory) {
		// TODO Auto-generated method stub
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			entry.accept(this);

		}
		currentdir = savedir;
	}

}
