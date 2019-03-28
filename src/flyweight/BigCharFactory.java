package flyweight;

import java.util.HashMap;

/**
 * BigcharFactory类(代码清单20-13)是生成BigChar类的实例的工厂(factory)。它实现了共享实例的功能。
 * poo1字段用于管理已经生成的BigChar类的实例。Pool有泳池的意思。现在任何存放某些东西的地方都可以被叫作Pool。
 * 泳池存储的是水，而BigCharEactory的pool中存储的则是已经生成的BigChar类的实例。
 * 在BigCharFactory类中，我们使用java.uti1.lashMap类来管理“字符串→实例”之间的对应关系。
 * 使用java.uti1.HashMap类的put方法可以将某个字符串(键)与一个实例(值)关联起来。
 * 之后，就可以通过键来获取它相应的值。在示例程序中，我们将接收到的单个字符(例如3)作为键与表示3的BigChar的类的实例对应起来。
 * 我们使用了Singleton模式(第5章)来实现BigCharFactory类，这是因为我们只需要一个BigcharFactory类的实例就可以了。
 * getInstance 方法用于获取BigCharFactory类的实例(注意不是BigChar类的实例哟)。
 * getBigchar方法是Flyweight模式的核心方法。该方法会生成接收到的字符所对应的BigChar类的实例。
 * 不过，如果它发现字符所对应的实例已经存在，就不会再生成新的实例，而是将之前的那个实例返回给调用者。
 * 请仔细理解这段逻辑。该方法首先会通过poo1.get()方法查找，以调查是否存在接收到的字符(charname)所对应的BigChar类的实例。
 * 如果返回值为nu11，表示目前为止还没有创建该实例，于是它会通过new BigChar(charname);来生成实例，
 * 并通过poo1.put将该实例放入HashMap中。如果返回值不为nu11，则会将之前生成的实例返回给调用者。
 * 相信大家都看明白了，这里我们通过这种方式实现了共享BigChar类的实例。
 * 为什么我们要使用synchronized关键字修饰getBigChar方法呢？我们会在习题20-3中来讨论这个问题。
 * 
 * @author KANYUN
 *
 */
public class BigCharFactory {
	/**
	 * 管理已经生成的BigChar的实例
	 */
	private HashMap pool = new HashMap();
	/**
	 * singleton模式
	 */
	private static BigCharFactory singleton = new BigCharFactory();

	/**
	 * 构造函数
	 */
	private BigCharFactory() {

	}

	/**
	 * 获取唯一的实例
	 */
	public static BigCharFactory getInstance() {
		return singleton;
	}

	/**
	 * 生成(共享)BigChar类的实例
	 */
	public synchronized BigChar getBigChar(char charname) {
		BigChar bigChar = (BigChar) pool.get("" + charname);
		if (bigChar == null) {
			bigChar = new BigChar(charname);
			// 生成BigChar的实倒
			pool.put("" + charname, bigChar);
		}
		return bigChar;
	}

}
