package visitor;

import visitor.Entry;

/**
 * File类（代码清单13-4）也与Composite模式中的Fi1e类一样。当然，在Visitor模式中要注意理解它是如何实现accept接口的。
 * accept方法的参数是Visitor类，然后accept方法的内部处理是“v.visit（this）；”，
 * 即调用了Visitor类的visit方法。visit方法被重载了，此处调用的是visit（File）。这是因为这里的this是File类的实例。
 * 通过调用visit方法，可以告诉Visitor“正在访问的对象是File类的实例this”
 * （大家在阅读代码后可能仍然难以透彻地理解visit方法和accept方法之间的关系，稍后我们会结合本章时序图
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
		return size;
	}
	
	@Override
	public String toString() {
		return "File [name=" + name + ", size=" + size + "]";
	}

}
