package prototype;

import java.util.HashMap;

/**
 * Manager类（代码清单6-2）使用Product接口来复制实例。
 * showcase字段是java.util.HashMap类型，它保存了实例的“名字”和“实例”之间的对应关系。
 * register方法会将接收到的1组“名字”和“Product接口”注册到showcase中。这里的Product类型的参数proto具体是什么呢？
 * 现在我们还无法知道proto到底是哪个类，但有一点可以确定的是，
 * 它肯定是实现了Product接口的类的实例（也就是说可以调用它的use方法和createClone方法）。
 * 请注意，在Product接口和Manager类的代码中完全没有出现MessageBox类和UnderlinePen类的名字，
 * 这也意味着我们可以独立地修改product和Manager，不受MessageBox类和Under1inePen类的影响。
 * 这是非常重要的，因为一旦在类中使用到了别的类名，就意味着该类与其他类紧密地耦合在了一起。
 * 在Manager类中，并没有写明具体的类名，仅仅使用了product这个接口名。也就是说，Product接口成为了连接Manager类与其他具体类之间的桥梁。
 * 
 * @author KANYUN
 *
 */
public class Manager {
	private HashMap showcase = new HashMap<>();

	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}

	public Product ctreate(String name) {
		Product product = (Product) showcase.get(name);
		return product.createClone();
	}
}
