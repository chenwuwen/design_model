package strategy;

/**
 * Hand类（代码清单10-1）是表示猜拳游戏中的：手势”的类。在该类的内部，
 * 用int表示所出的手势，其中0表示石头，1表示剪刀，2表示布，并将值保存在handValue字段中。
 * 我们只需要3个Hand类的实例。在程序的开始，创建这3个实例，并将它们保存在hand数组中。
 * Hand类的实例可以通过使用类方法getHand来获取。只要将表示手势的值作为参数传递给getHand方法，它就会将手势的值所对应的Hand类的实例返回给我们。
 * 这也是一种Singleton模式（第5章）。
 * isStrongerThan方法和isWeakerThan方法用于判断猜拳结果。例如，如果有手势hand1和手势hand2，那么可以像下面这样判断猜拳结果。
 * hand1.isStrongerThan（hand2）；hand1.isWeakerThan（hand2）；
 * 在该类的内部，实际负责判断猜拳结果的是fight方法，其判断依据是手势的值。
 * 代码清单10-1中的（this.handvalue+1）%3==h.handvalue表达式可能会有些难以理解，
 * 所以这里稍微说明一下。如果this的手势值加1后是h的手势值
 * （例如，如果this的手势是石头，而h是剪刀，或是this的手势是剪刀，而h是布，或是this的手势是布，而h是石头），
 * 那么判断this获胜。之所以使用“”运算符进行取余数计算，是希望布（2）加1后，变成石头（0）。
 * 在上面的语句中，出现了this.handvalue，这是为了让读者能够注意到它与h.handvalue的区别。
 * 在程序中，即使写作（handvalue+1）%3==h.handvalue，意思也是完全一样的。
 * 虽然Hand类会被其他类（Player类、Winningstrategy类、ProbStrategy类）使用，但它并非Strategy模式中的角色。
 * 
 * @author KANYUN
 *
 */
public class Hand {
	public static final int HANDVALUE_GUU = 0;// 表示石头的值
	public static final int HANDVALUE_CHO = 1;// 表示剪刀的值
	public static final int HANDVALUE_PAA = 2;// 表示布的值
	/**
	 * 表示猜攀中3种手势的实例
	 */
	public static final Hand[] hand = { new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA), };
	/**
	 * 表示猜拳中手势所对应的字符串
	 */
	private static final String[] name = { "石头", "剪刀", "布" };
	/**
	 * 猜攀中出的手势的值
	 */
	private int handvalue;

	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}

	/**
	 * 根据手势的值获取其对应的实例
	 * 
	 * @param handvalue
	 * @return
	 */
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}

	/**
	 * 如果this胜了h则返回true
	 * 
	 * @param h
	 * @return
	 */
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}

	/**
	 * 如果this输了h则返回true
	 * 
	 * @param h
	 * @return
	 */
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}

	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name[handvalue];
	}
}
