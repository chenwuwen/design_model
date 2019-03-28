package abstract_factory.factory;

/**
 * 代码清单8-5中的getFactory方法可以根据指定的类名生成具体工厂的实例。例如，可以像下面这样，
 * 将参数classname指定为具体工厂的类名所对应的字符串。 “1istfactory.ListFactory"
 *
 * createlink、createTray、createPage等方法是用于在抽象工厂中生成零件和产品的方法。这些方法都是抽象方法，
 * 具体的实现被交给了Factory类的子类。不过，这里确定了方法的名字和签名。
 * 
 * @author KANYUN
 *
 */
public abstract class Factory {
	/**
	 * getFactory方法通过调用C1ass类的forName方法来动态地读取类信息，
	 * 接着使用newInstance方法生成该类的实例，并将其作为返回值返回给调用者。
	 * Class类属于ava，lang包，是用来表示类的类。Class类包含于Java的标准类库中。
	 * forName是java.1ang.Class的类方法（静态方法），newInstance则是java.lang. Class的实例方法。
	 * 请注意，虽然getFactory方法生成的是具体工厂的实例，但是返回值的类型是抽象工厂类型。
	 * 
	 * @param classname
	 * @return
	 */
	public static Factory getFactory(String classname) {
		Factory factory = null;
		try {
			factory = (Factory) Class.forName(classname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("没有找到：" + classname + "类");
		}
		return factory;
	}

	public abstract Link createLink(String caption, String url);

	public abstract Tray createTray(String caption);

	public abstract Page createPage(String title, String author);
}
