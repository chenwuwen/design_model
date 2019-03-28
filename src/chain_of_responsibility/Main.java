package chain_of_responsibility;

/**
 * Main类(代码清单14-7)首先生成了Alice至Fred等6个解决问题的实例。 虽然此处定义的变量都是support类型的,
 * 但是实际上所保存的变量却是NoSupport、LimitSupprot、SpecialSupport、oddSupport等各个类的实例。
 * 接下来,Main类调用setNext方法将Alice至Fred这6个实例串联在职责链上。
 * 之后,Main类逐个生成问题,并将它们传递给alice,然后显示最终谁解决了该问题。
 * 请注意,这里的问题编号从0开始,增长步长为33。这里的33并没有什么特别的意思,我们只是随便使用一个增长步长使程序更有趣而已。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("E1mo");
		Support fred = new LimitSupport("Fred", 300);
		// 形成职责链
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		// 制造各种问题
		for (int i = 0; i < 500; i += 33) {
			alice.support(new Trouble(i));
		}
	}
}
