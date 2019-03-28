package observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * NumberGenerator类（代码清单17-2）是用于生成数值的抽象类。
 * 生成数值的方法（execute方法）和获取数值的方法（getNumber方法）都是抽象方法，需要子类去实现。
 * observers字段中保存有观察NumberGenerator的 observer们。 addobserver 方法用于注册 Observer，而
 * deleteobserver 方法用于删除 Observer。
 * notifyobservers方法会向所有的observer发送通知，告诉它们“我生成的数值发生了变化，请更新显示内容”。
 * 该方法会调用每个observer的update方法。
 * 
 * @author KANYUN
 *
 */
public abstract class NumberGenerator {
	/**
	 * 保存Observer们
	 */
	private ArrayList observers = new ArrayList();

	/**
	 * 注册 Observer
	 * 
	 * @param observer
	 */
	public void addobserver(Observer observer) {//
		observers.add(observer);
	}

	/**
	 * 剧除Observer
	 * 
	 * @param observer
	 */
	public void deleteobserver(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * 向Observer发送通知
	 */
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer) iterator.next();
			observer.update(this);

		}
	}

	/**
	 * 获取数值
	 * 
	 * @return
	 */
	public abstract int getNumber();

	/**
	 * 生成数值
	 * 
	 * @return
	 */
	public abstract void execute();
}
