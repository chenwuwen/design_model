package composite;

/**
 * File类（代码清单11-2）是表示文件的类，它是Entry类的子类。
 * 在Fi1e类中有两个字段，一个是表示文件名的name字段，另一个是表示文件大小的size字段。
 * 调用Fi1e类的构造函数，则会根据传入的文件名和文件大小生成文件实例。例如以下语句就会创建出一个文件名为readme.txt，文件大小为1000的“文件”。
 * 当然这里创建出的文件是虚拟的文件，程序并不会在真实的文件系统中创建出任何文件。
 * new File（"readme.txt"，1000）
 * getName方法和getSize方法分别返回文件的名字和大小。
 * 此外，File类还实现了父类要求它实现的printList（String）方法，具体的显示方式是用”/”分隔prefix和表示实例自身的文字。
 * 这里我们使用了表达式"/”+this。像这样用字符串加上对象时，程序会自动地调用对象的toString方法。这是Java语言的特点。
 * 也就是说下面这些的表达式是等价的。
 * prefix+"/"+this
 * prefix+"/"+this.tostring（）
 * prefix+"/"+tostring（）
 * 因为Fi1e类实现了父类Entry的abstract方法，因此Fi1e类自身就不是抽象类了。
 * 
 * @author KANYUN
 *
 */
public class File extends Entry {
	private String name;
	private int size;

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + "/" + this);
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", size=" + size + "]";
	}

	
}
