package memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Gamer类(代码清单18-2)是表示游戏主人公的类。
 * 它有3个字段,即所持金钱(money)、获得的水果(fruits)以及一个随机数生成器(random)。而且还有一个名为fruitsname的静态字段。
 * 进行游戏的主要方法是bet方法。在该方法中,只要主人公没有破产,就会一直掷骰子,并根据骰子结果改变所持有的金钱数目和水果个数。
 * createMemento方法的作用是保存当前的状态(拍摄快照)。
 * 在createMemento方法中,会根据当前在时间点所持有的金钱和水果生成一个Memento类的实例,
 * 该实例代表了"当前Gamer的状态”,它会被返回给调用者。就如同给对象照了张照片一样,我们将对象现在的状态封存在Memento类的实例中。
 * 请注意我们只保存了"好吃”的水果。 restoreMemento方法的功能与createMemento相反,
 * 它会根据接收到的Memento类的实例来将Gamer恢复为以前的状态,仿佛是在游戏中念了一通"复活咒语”一样。
 * 
 * @author KANYUN
 *
 */
public class Gamer {

	/**
	 * 所持金钱
	 */
	private int money;
	/**
	 * 获得的水果
	 */
	private List fruits = new ArrayList();
	/**
	 * 随机数生成器
	 */
	private Random random = new Random();
	/**
	 * 表示水果种类的数组
	 */
	private static String[] fruitsname = { "苹果", "葡萄", "香蕉", "橙子" };

	/**
	 * 构造函数
	 * 
	 * @param money
	 */
	public Gamer(int money) {
		this.money = money;
	}

	/**
	 * 获取当前所持金钱
	 * 
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * 投掷骰子进行游戏
	 */
	public void bet() {

		int dice = random.nextInt(6) + 1;
		// 骰子结果为1时,增加所持金钱
		if (dice == 1) {
			money += 100;
			System.out.println("所持金钱增加了。");
		} else if (dice == 2) {// 骰子结果为2时,所持金钱减半
			money /= 2;
			System.out.println("所持金钱减半了。");
		} else if (dice == 6) {// 骰子结果为6时,获得水果
			String f = getFruit();
			System.out.println("获得了水果(" + f + ")。");
			fruits.add(f);
		} else { // 骰子结果为3、4、5则什么都不会发生
			System.out.println("什么都没有发生。");
		}
	}

	/**
	 * 拍摄快照
	 */
	public Memento createMemento() {

		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while (it.hasNext()) {
			String f = (String) it.next();
			// 只保存好吃的水果
			if (f.startsWith("好吃的")) {
				m.addFruit(f);
			}
		}
		return m;
	}

	/**
	 * 撤销
	 * 
	 * @param memento
	 */
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	/**
	 * 用字符串表示主人公状态
	 * 
	 * @return
	 */
	public String toString() {
		return "[money=" + money + ",fruits-" + fruits + "]";
	}

	/**
	 * 获得一个水果
	 * 
	 * @return
	 */
	private String getFruit() {
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "好吃的";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
