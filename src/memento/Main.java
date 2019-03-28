package memento;

/**
 * Main类(代码清单18-3)生成了一个Gamer类的实例并进行游戏。它会重复调用Gamer的bet方法，并显示Gamer的所持金钱。
 * 到目前为止，这只是普通的掷骰子游戏，接下来我们来引入Memento模式。在变量memento中保存了“某个时间点的Gamer的状态”。如果运气很好，金钱增加了，会调用createMemento方法保存现在的状态;如果运气不好，金钱不足了，就会调用restoreMemento方法将钱还给memento。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		// 最初的所持金钱数为100

		Gamer gamer = new Gamer(100);
		//// 保存最初的状态
		Memento memento = gamer.createMemento();
		for (int i = 0; i < 100; i++) {
			// 显示掷酸子的次数
			System.out.println("====" + i);
			// 显示主人公现在的状态
			System.out.println("当前状态：" + gamer);
			// 进行游戏
			gamer.bet();
			System.out.println("所持金钱为" + gamer.getMoney() + "元。");
			// 决定如何处理 Memento
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("(所持金钱增加了许多，因此保存游戏当前的状态)");
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				System.out.println("(所持金钱减少了许多，因此将游戏恢复至以前的状态)");
				gamer.restoreMemento(memento);
			}

			// 等待一段时间
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("");
			}
		}

	}
}
