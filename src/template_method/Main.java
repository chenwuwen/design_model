package template_method;
/**
 * 由于d1,d2都是AbstractDisplay的子类，因此他们都可以调用display()方法
 * 实际程序行为取决于各个子类的具体实现
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("HELLO WORLD!");

		d1.display();
		d2.display();

	}
}
