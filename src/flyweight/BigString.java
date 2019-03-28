package flyweight;

/**
 * Bigstring类(代码清单20-14)表示由‘Bigchar组成的“大型字符串”的类。
 * bigchars字段是Bigchar类型的数组，它里面保存着BigChar类的实例。在构造函数的for语句中，我们并没有像下面这样使用new关键字来生成BigChar类的实例。
 * for(inti=0;i< bigchars.length;i++){ 
 * 		bigchars[il=new Bigchar(string.charAt(1)); // 不共享实例
 * }
 *	而是调用了getBigchar方法，具体如下。
 * BigCharFactory factory=BigcharFactory.getInstance();
 * for(inti=0;i< bigchars.length;i++){
 * 		bigchars[i]=factory.getBigchar(string.charAt()); // 共享实例
 * }
 * 由于调用了BigCharFactory方法，所以对于相同的字符来说，可以实现BigChar类的实例共享。
 * 例如，当要生成字符串“1212123·对应的BigString类的实例时，bigchars字段如图20-2所示。
 * @author KANYUN
 *
 */
public class BigString {
	/**
	 * 大型字符”的数组
	 */
	private BigChar[] bigchars;

	/**
	 * 构造函数
	 */
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}

	/**
	 * 显示
	 */
	public void print() {
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i].print();
		}
	}
}
