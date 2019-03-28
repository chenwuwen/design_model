package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento类（代码清单18-1）是表示Gamer（主人公）状态的类。 Memento类和Gamer类都位于game包下。
 * Memento类中有两个字段，即money和fruits。money表示主人公现在所持有的金钱数目，fruits表示现在为止所获得的水果。
 * 之所以没有将money和fruits的可见性设为private，是因为我们希望同在game包下的Gamer类可以访问这两个字段。
 * getMoney方法的作用是获取主人公当前所持有的金钱数目。
 * Memento类的构造函数的可见性并非public，因此并不是任何其他类都可以生成Memento类的实例。
 * 只有在同一个包（本例中是game包）下的其他类才能调用Memento类的构造函数。
 * 具体来说，只有game 包下的Gamer 类才能生成Memento类的实例。
 * addFruit方法用于添加所获得的水果。该方法的可见性也不是public。这是因为只有同一个包下的其他类才能添加水果。
 * 因此，无法从game包外部改变Memento内部的状态。
 * 此外，Memento类中有“narrow interface”和“wide interface”这样的注释。关于这一点，稍后本章18.3一节会做详细说明。
 * 
 * @author KANYUN
 *
 */
public class Memento {
	/**
	 * 所持金钱
	 */
	int money;
	/**
	 * 获得的水果
	 */
	ArrayList fruits;

	/**
	 * 获得当前持有的金钱（narrow interface[窄接口]）
	 * 
	 * @return
	 */
	public int getMoney() {
		// TODO Auto-generated method stub
		return money;
	}

	/**
	 * 构造函数（wide interface[宽接口]）
	 */
	Memento(int money) {
		this.money = money;
		this.fruits = fruits;
	}

	/**
	 * 添加水果（wide interface[宽接口]）
	 * 
	 * @param fruit
	 */
	void addFruit(String fruit) {
		// TODO Auto-generated method stub
		fruits.add(fruit);
	}

	/**
	 * 获取所持有的水果（wide interface[宽接口]）
	 * 
	 * @return
	 */
	List getFruits() {
		return (List) fruits.clone();
	}

}
