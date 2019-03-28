package strategy;

import java.util.Random;

/**
 * ProbStrategy类（代码清单10-4）是另外一个具体策略，这个策略就需要“动点脑筋”了。
 * 虽然它与WinningStrategy类一样，也是随机出手势，但是每种手势出现的概率会根据以前的猜拳结果而改变。
 * history字段是一个表，被用于根据过去的胜负来进行概率计算。它是一个二维数组，每个数组下标的意思如下。
 * history[上一局出的手势][这一局所出的手势] 这个表达式的值越大，表示过去的胜率越高。 下面稍微详细讲解下。 假设我们上一局出的是石头。
 * history[0][0]两局分别出石头、石头时胜了的次数history[0][1]两局分别出石头、剪刀时胜了的次数history[o][2]两局分别出石头、
 * 布时胜了的次数那么，我们就可以根据history[0][0]、history[0][1]、history[0][2]这3个表达式的值从概率上计算出下一局出什么。
 * 简而言之，就是先计算3个表达式的值的和（getSum方法），然后再从0与这个和之间取一个随机数，并据此决定下一局应该出什么（nextHand方法）。
 * 例如，如果history[0][0]是3history[0][1]是5history[0][2]是7那么，下一局出什么就会以石头、剪刀和布的比率为3：5：7来决定。
 * 然后在0至15（不含15，15是3+5+7的和）之间取一个随机数。
 * 如果该随机数在0至3（不含3）之间，那么出石头如果该随机数在3至8（不含8）之间，那么出剪刀 如果该随机数在8至15（不含15）之间，那么出布study
 * 方法会根据nextHand方法返回的手势的胜负结果来更新history字段中的值。
 * 
 * @author KANYUN
 *
 */
public class ProbStrategy implements Strategy {
	private Random random;
	private int prevHandvalue = 0;
	private int currentHandvalue = 0;

	private int[][] history = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, };

	public ProbStrategy(int seed) {
		super();
		random = new Random(seed);
	}

	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		int bet = random.nextInt(getSum(currentHandvalue));
		int handvalue = 0;
		if (bet < history[currentHandvalue][0]) {
			handvalue = 0;
		} else if (bet < history[currentHandvalue][0] + history[currentHandvalue][1]) {
			handvalue = 1;
		} else {
			handvalue = 2;

		}
		prevHandvalue = currentHandvalue;
		currentHandvalue = handvalue;
		return Hand.getHand(handvalue);
	}

	private int getSum(int hv) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += history[hv][i];
		}
		return sum;
	}

	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		if (win) {
			history[prevHandvalue][currentHandvalue]++;
		} else {
			history[prevHandvalue][(currentHandvalue + 1) % 3]++;
			history[prevHandvalue][(currentHandvalue + 2) % 3]++;
		}

	}
}
