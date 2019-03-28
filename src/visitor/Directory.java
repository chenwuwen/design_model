package visitor;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory;

/**
 * Directory类（代码清单13-5）是表示文件夹的类。与Composite模式中的Directory类相比，
 * 本章中的Directory类中增加了下面两个方法。
 * 第一个方法是iterator方法。iterator方法会返回rterator，我们可以使用它遍历文件夹中的所有目录条目（文件和文件夹）。
 * 第二个方法当然就是accept方法了。与File类中的accept方法调用了visit（File）方法一样，
 * Directory类中的accept方法调用了visit（Directory）方法。这样就可以告诉访问者“当前正在访问的是Directory类的实例”。
 * 
 * @author KANYUN
 *
 */
public class Directory extends Entry {
	private String name;
	private ArrayList dir = new ArrayList<>();

	public Directory(String name) {
		super();
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;
		Iterator iterator = dir.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			size += entry.getSize();
		}
		return size;
	}

	public Entry add(Entry entry) {
		dir.add(entry);
		return this;
	}

	public Iterator iterator() {
		return dir.iterator();
	}

	@Override
	public String toString() {
		return "Directory [getName()=" + getName() + ", getSize()=" + getSize() + "]";
	}
	
}
