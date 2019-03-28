package state;

/**
 * Main类（代码清单19-8）生成了一个safeFrame类的实例并每秒调用一次setclock方法，对该实例设置一次时间。这相当于在真实世界中经过了一小时。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		SafeFrame safeFrame = new SafeFrame(" state sample ");
		while (true) {
			for (int hour = 0; hour < 24; hour++) {
				// 设置时间
				safeFrame.setClock(hour);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
