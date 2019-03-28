package chain_of_responsibility;

/**
 * Support类(代码清单14-2)是用来解决问题的抽象类，它是职责链上的对象。
 * next字段中指定了要推卸给的对象。可以通过setNext方法设定该对象。
 * resolve方法是需要子类去实现的抽象方法。如果resolve返回true，则表示问题已经被处理，
 * 如果返回fa1se则表示问题还没有被处理(即需要被推卸给下一个对象)。Resolve有“解决”的意思。
 * support方法会调用resolve方法，如果resolve方法返回false，则support方法会将问题转交给下一个对象。
 * 如果已经到达职责链中的最后一个对象，则表示没有人处理问题，将会显示出处理失败的相关信息。
 * 在本例中我们只是简单地输出处理失败的相关信息，但根据需求不同，有时候也需要抛出异常。
 * 顺便告诉大家，support方法调用了抽象方法resolve，因此它属于Template Method模式(第3章)。
 * 
 * @author KANYUN
 *
 */
public abstract class Support {
	/**
	 * 解决问题的实例的名字
	 */
	private String name;
	/**
	 * 要推卸给的对象
	 */
	private Support next;

	/**
	 * 生成解决问题的实例
	 * @param name
	 */
	public Support(String name){
		this.name=name;
	}

	/**
	 * 设置要推卸给的对象
	 * 
	 * @param next
	 * @return
	 */
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}

	/**
	 * 解决问题的步骤
	 * 
	 * @param trouble
	 */
	public final void support(Trouble trouble) {
		if (resolve(trouble)) {
			done(trouble);
		}else if (next != null) {
			next.support(trouble);
		}else {
			fail(trouble);
		}
	}

	/**
	 * 解决问题的方法
	 */

	protected abstract boolean resolve(Trouble trouble);

	/**
	 * 解决
	 * 
	 * @param trouble
	 */
	protected void done(Trouble trouble) {
		System.out.println(trouble + "is resolved by" + this + ".");
	}

	/**
	 * 未解决
	 * 
	 * @param trouble
	 */
	protected void fail(Trouble trouble) {
		System.out.println(trouble + "cannot be resolved.");
	}

	/**
	 * 显示字符串
	 * 
	 * @return
	 */
	public String toString() {
		return "[" + name + "]";
	}
}
