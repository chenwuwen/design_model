package strategy;

/**
 * Main类（代码清单10-6）负责使用以上类让电脑进行猜拳游戏。 这里Main类让以下两位选手进行10000局比赛，然后显示比赛结果。
 * ·姓名："Taro"、策略：Winningstrategy ·姓名："Hana”、策略：ProbStrategy
 * 此外，"winner:”+player1与“Winner:"+playerl.tostring（）的意思是一样的。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Main random seed1 random seed2");
			System.out.println("Example: java Main 31415");
			System.exit(0);
		}

		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);
		Player player1 = new Player("Taro", new Winningstrategy(seed1));
		Player player2 = new Player("Hana", new ProbStrategy(seed2));
		for (int i = 0; i < 10000; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if (nextHand1.isStrongerThan(nextHand2)) {
				System.out.println("Winner:" + player1);
				player1.win();
				player2.lose();
			} else if (nextHand2.isStrongerThan(nextHand1)) {
				System.out.println("Winner:" + player2);
				player1.lose();
				player2.win();
			} else {
				System.out.println("Even..…");
				player1.even();
				player2.even();
			}
		}
		System.out.println("Total result:");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
	}
}
