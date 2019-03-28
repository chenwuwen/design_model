package strategy;

/**
 * Player类（代码清单10-5）是表示进行猜拳游戏的选手的类。 在生成Player类的实例时，需要向其传递“姓名”和“策略”。
 * nextHand方法是用来获取下一局手势的方法，不过实际上决定下一局手势的是各个策略。
 * Player类的nextHand方法的返回值其实就是策略的nextHand方法的返回值。
 * nextHand方法将自己的工作委托给了Strategy，这就形成了一种委托关系。
 * 在决定下一局要出的手势时，需要知道之前各局的胜（win）、负（lose）、平（even）等结果，
 * 因此Player类会通过strategy字段调用study方法，然后study方法会改变策略的内部状态。
 * wincount、losecount和gamecount用于记录选手的猜拳结果。
 * 
 * @author KANYUN
 *
 */
public class Player {
	private String name;
	private Strategy strategy;
	private int winCount;
	private int loseCount;
	private int gameCount;

	/**
	 * 赋予姓名和策略
	 * 
	 * @param name
	 * @param strategy
	 */
	public Player(String name, Strategy strategy) {
		super();
		this.name = name;
		this.strategy = strategy;
	}

	public Hand nextHand() {
		return strategy.nextHand();
	}

	/**
	 * 胜
	 */
	public void win() {
		strategy.study(true);
		winCount++;
		gameCount++;
	}

	/**
	 * 负
	 */
	public void lose() {
		strategy.study(false);
		loseCount++;
		gameCount++;
	}

	/**
	 * 平
	 */
	public void even() {
		gameCount++;
	}

	public String toString() {
		return "[" + name + ":" + gameCount + " games, " + winCount + " win , " + loseCount + " lose " + "]";
	}

}
