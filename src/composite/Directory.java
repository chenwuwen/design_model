package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import abstract_factory.factory.Factory;
import abstract_factory.factory.Link;
import abstract_factory.factory.Page;
import abstract_factory.factory.Tray;

/**
 * Directory类（代码清单11-3）是表示文件夹的类。它也是Entry类的子类。
 * 在Directory类中有两个字段，一个是表示文件夹名字的name字段，这一点与File类相同。
 * 不过，在Directory类中，我们并没有定义表示文件夹大小的字段，这是因为文件夹大小是自动计算出来的。
 * 另一个字段是directory，它是ArrayList类型的，它的用途是保存文件夹中的目录条目。
 * getName方法只是简单地返回了name，但在getsize方法中则进行了计算处理。它会遍历directory字段中的所有元素，然后计算出它们的大小的总和。
 * 请注意以下语句。
 * size+=entry.getsize（）；这里，在变量size中加上了entry的大小，但entry可能是File类的实例，也可能是Directory类的实例。
 * 不过，不论它是哪个类的实例，我们都可以通过getsize方法得到它的大小。这就是Composite模式的特征——“容器与内容的一致性”——的表现。
 * 不管entry究竟是Fi1e类的实例还是Directory类的实例，它都是Entry类的子类的实例，因此可以放心地调用getsize方法。
 * 即使将来编写了其他Entry类的子类，它也会实现getsize方法，因此Directory类的这部分代码无需做任何修改。
 * 如果entry是Directory类的实例，调用entry.getsize（）时会将该文件夹下的所有目录条目的大小加起来。
 * 如果其中还有子文件夹，又会调用子文件夹的getsize方法，形成递归调用。
 * 这样一来，大家应该能够看出来，getsize方法的递归调用与Composite模式的结构是相对应的。
 * add方法用于向文件夹中加入文件和子文件夹。该方法并不会判断接收到的entry到底是Directory类的实例还是Fi1e类的实例，
 * 而是通过如下语句直接将目录条目加入至directory字段中。“加入”的具体处理则被委托给了ArrayList类。
 * directory.add（entry）；
 * printList方法用于显示文件夹的目录条目一览。printList方法也会递归调用，这一点和getSize方法一样。
 * 而且，printList方法也没有判断变量entry究竟是Fi1e类的实例还是Directory类的实例，
 * 这一点也与getsize方法一样。这是因为容器和内容具有一致性。
 * 
 * @author KANYUN
 *
 */
public class Directory extends Entry {
	/**
	 * 文件夹名称
	 */
	private String name;
	/**
	 * 文件夹中目录条目集合
	 */
	private ArrayList directory = new ArrayList();

	public Directory(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * 增加目录条目
	 */
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			size += entry.getSize();

		}
		return size;
	}

	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + "/" + this);
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			entry.printList(prefix + "/" + name);

		}
	}

	@Override
	public String toString() {
		return "Directory [getName()=" + getName() + ", getSize()=" + getSize() + "]";
	}

	
}
