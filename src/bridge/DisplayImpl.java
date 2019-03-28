package bridge;

/**
 * 现在，我们来看桥的另外一侧——“类的实现层次结构”。 DisplayImp1类（代码清单9-3）位于“类的实现层次结构”的最上层。
 * DisplayImp1类是抽象类，它声明了rawopen、rawPrint、rawclose这3个抽象方法，
 * 它们分别与Display类的open、print、close方法相对应，进行显示前、显示、显示后处理。
 * 
 * @author KANYUN
 *
 */
public abstract class DisplayImpl {

	public abstract void rawOpen();

	public abstract void rawPrint();

	public abstract void rawClose();

}
