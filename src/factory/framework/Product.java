package factory.framework;

import javax.jws.soap.SOAPBinding.Use;

/**
 * 是用来表示“产品”的类，在该类中仅声明use的抽象方法，具体实现交由子类
 * 在这个框架中，定义了产品是"任意可以use"的东西
 * 
 * @author KANYUN
 *
 */
public abstract class Product {
	public abstract void use();
}
