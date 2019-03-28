package factory.framework;

/**
 * 在framework包中的Factory类（代码清单4-2）中，我们使用了Template Method模式。
 * 该类还声明了用于“生成产品”的createProduct抽象方法和用于“注册产品”的registerProduct抽象方法。
 * “生成产品”和“注册产品”的具体处理则被交给了Factory类的子类负责。
 * 在这个框架中，我们定义了工厂是用来“调用create方法生成Product实例”的。而create方法的实现是先调用createProduct生成产品，
 * 接着调用registerProduct 注册产品。 具体的实现内容根据Factory Method模式适用的场景不同而不同。但是，只要是Factory
 * Method模式， 在生成实例时就一定会使用到Template Method模式。
 * 
 * @author KANYUN
 *
 */
public abstract class Factory {
	public final Product create(String owner) {
		Product product = createProduct(owner);
		registerProduct(product);
		return product;
	}

	protected abstract void registerProduct(Product product);

	protected abstract Product createProduct(String owner);
}
