package observer;

import java.util.Random;

/**
 * RandomNumberGenerator类（代码清单17-3）是NumberGenerator的子类，它会生成随机数。
 * random字段中保存有ava.util.Random类的实例（即随机数生成器）。而number字段中保存的是当前生成的随机数。
 * getNumber方法用于获取number字段的值。
 * execute方法会生成20个随机数（0~49的整数），并通过notifyobservers方法把每次生成结果通知给观察者。
 * 这里使用的nextInt方法是java.util.Random类的方法，它的功能是返回下一个随机整数值（取值范围大于0，小于指定值）。
 * 
 * @author KANYUN
 *
 */
public class RandomNumberGenerator extends NumberGenerator {
	/**
	 * 随机数生成器
	 */
	private Random random = new Random();

	/**
	 * 当前数值
	 */
	private int number;

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}

}
