package observer;

/**
 * Graphobserver类（代码清单17-5）也实现了Observer接口。 
 * 该类会将观察到的数值以 ***** 这样的简单图示的形式显示出来。
 * 
 * @author KANYUN
 *
 */
public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator numberGenerator) {
		// TODO Auto-generated method stub
		System.out.print("GraphObserver:");
		int count = numberGenerator.getNumber();
		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		System.out.println("");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


