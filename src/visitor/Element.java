package visitor;

/**
 * Visitor类是表示访问者的类，而Element接口（代码清单13-2）则是接受访问者的访问的接口。
 * 如果将Visitor比喻为玛利亚，Element接口就相当于住宿的地方（实现了Element接口的类的实例才是实际住宿的地方）。
 * E1ement 接口中声明了accept方法（accept在英文中是“接受”的意思）。该方法的参数是访问者Visitor类。
 * 
 * @author KANYUN
 *
 */
public interface Element {
	public void accept(Visitor visitor);
}
