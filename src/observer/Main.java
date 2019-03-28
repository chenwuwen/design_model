package observer;

/**
 * Main类（代码清单17-6）生成了一个RandomNumberGenerator类的实例和两个观察者，
 * 其中observer1是Digitobserver类的实例，observer2是Graphobserver类的实例。
 * 在使用addobserver注册观察者后，它还会调用generator.execute方法生成随机数值。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		NumberGenerator generator = new RandomNumberGenerator();
		Observer observer1 = new DigitObserver();
		Observer observer2 = new GraphObserver();
		generator.addobserver(observer1);
		generator.addobserver(observer2);
		generator.execute();
	}
}
