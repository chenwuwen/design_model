package state;

/**
 * Daystate类（代码清单19-4）表示白天的状态。该类实现了state接口，因此它还实现了State接口中声明的所有方法。
 * 对于每个表示状态的类，我们都只会生成一个实例。因为如果每次发生状态改变时都生成一个实例的话，太浪费内存和时间了。为此，此处我们使用了Singleton模式（第5章）。
 * doclock是用于设置时间的方法。如果接收到的参数表示晚上的时间，就会切换到夜间状态，即发生状态变化（状态迁移）。在该类中，我们调用Context接口的changeState方法改变状态。表示晚上状态的类是NightState类，可以通过Nightstate类的getInstance方法获取它的实例（这里使用了Singleton模式。请注意我们并没有通过new
 * Nightstate（）来生成Nightstate类的实例。）。
 * douse、doAlarm、dophone分别是使用金库、按下警铃、正常通话等事件对应的方法。
 * 它们的内部实现都是调用Context中的对应方法。
 * 请注意，在这些方法中，并没有任何“判断当前状态”的if语句。
 * 在编写这些方法时，开发人员都知道“现在是白天的状态”。在State模式中，每个状态都用相应的类来表示，因此无需使用if语句或是switch语句来判断状态。
 * 
 * @author KANYUN
 *
 */
public class DayState implements State {

	private static DayState instance = new DayState();

	/**
	 * 单例
	 */
	private DayState() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static DayState getInstance() {
		return instance;
	}

	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		if (hour < 9 || 17 <= hour) {
			context.changeSate(NightState.getInstance());
		}

	}

	@Override
	public void doAlarm(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("按下警铃（白天）");
	}

	@Override
	public void doPhone(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("正常通话（白天）");
	}

	@Override
	public void doUse(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("使用金库（白天）");
	}

	@Override
	public String toString() {
		return "[白天]";
	}
}
