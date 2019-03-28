package visitor;

/**
 * Visitor类（代码清单13-1）是表示访问者的抽象类。访问者依赖于它所访问的数据结构（即File类和Directory类）。
 * Visitor类中定义了两个方法，名字都叫visit。不过它们接收的参数不同，一个接收File类型的参数，另一个接收Directory类型的参数。
 * 从外部调用visit方法时，程序会根据接收的参数的类型自动选择和执行相应的visit方法。通常，我们称这种方式为方法的重载。
 * visit（File）是用于访问File类的方法，visit（Directory）则是用于访问Directory类的方法。
 * 在Visitor模式中，各个类之间的相互调用非常复杂，单看Visitor类是无法整体理解该模式的。
 * 这里，我们在理解了Visitor类中定义的两个visit方法后，就接着看下一个类吧。
 * 
 * @author KANYUN
 *
 */
public abstract class Visitor {
	public abstract void visit(File file);

	public abstract void visit(Directory directory);
}
