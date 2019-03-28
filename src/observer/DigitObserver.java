package observer;

/**
 * Digitobserver类（代码清单17-4）实现了observer接口，它的功能是以数字形式显示观察到的数值。
 * 它的update方法接收NumberGenerator的实例作为参数，
 * 然后通过调用NumberGenerator类的实例的getNumber方法可以获取到当前的数值，并将这个数值显示出来。
 * 为了能够让大家看清它是如何显示数值的，这里我们使用Thread.sleep来降低了程序的运行速度。
 * 
 * @author KANYUN
 *
 */
public class DigitObserver implements Observer {

	@Override
	public void update(NumberGenerator numberGenerator) {
		// TODO Auto-generated method stub
		System.out.println("DigitObserver:" + numberGenerator.getNumber());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
