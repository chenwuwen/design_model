package decorator;

/**
 * Border类（代码消单|2-3）是装边框的捆象类。虽然它所表示的是装饰边框，但也是Display类的子类。
 * 也就是说，通过继承，装饰边框与被装饰物具有了相同的方法。
 * 具体而言，Border类继承了父类的getColumns、getRows、getRowText、show等各方法。
 * 从接口（API）角度而言，装饰边框（Border）与被装饰物（Display）具有相同的方法也就意味着它们具有一致性。
 * 在装饰边框Border类中有一个Display类型的display字段，它表示被装饰物。
 * 不过，display字段所表示的被装饰物并仅不限于stringDisplay的实例。
 * 因为，Border也是Display类的子类，display字段所表示的也可能是其他的装饰边框（Border类的子类的实例），
 * 而且那个边框中也有一个display字段。这样，大家应该能大致理解 Decorator模式的结构了吧。
 * 
 * @author KANYUN
 *
 */
public abstract class Border extends Display {
	/**
	 * 表示被装饰物
	 */
	protected Display display;

	/**
	 * 在生成实例时，通过传入参数指定被装饰物
	 * 
	 * @param display
	 */
	protected Border(Display display) {
		super();
		this.display = display;
	}

}
