package strategy;

import java.util.Random;

/**
 * winningstrategy类（代码清单10-3）是Strategy接口的实现类之一，它实现了nextHand和study两个方法。
 * 该类的猜拳策略有些笨，如果上一局的手势获胜了，则下一局的手势就与上局相同（上一局出石头，下一局继续出石头；上一局出布，下一局继续出布）。
 * 如果上一局的手势输了，则下一局就随机出手势。 由于在Winningstrategy类中需要使用随机值，
 * 因此我们在random字段中保存了java.util.Random的实例。 也可以说，random字段是该类的一个随机数生成器。
 * 在won字段中保存了上一局猜拳的输赢结果。如果上一局猜拳获胜了，则won值为true；如果输了，则won值为false。
 * 在prevHand字段中保存的是上一局出的手势。
 * 
 * @author KANYUN
 *
 */
public class Winningstrategy implements Strategy {

	private Random random;
	private boolean won = false;
	private Hand prevHand;

	public Winningstrategy(int seed) {
		random = new Random(seed);
	}

	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		if (!won) {
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}

	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		won = win;
	}

}
