package state;

/**
 * NightState类（代码清单19-5）表示晚上的状态。它与Daystate类一样，也使用了Singleton模式。
 * Nightstate类的结构与Daystate完全相同，此处不再赘述。
 * 
 * @author KANYUN
 *
 */
public class NightState implements State {

	private static NightState instance = new NightState();

	/**
	 * 单例
	 */
	private NightState() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static NightState getInstance() {
		return instance;
	}

	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		if (9 <= hour || hour < 17) {
			context.changeSate(DayState.getInstance());
		}

	}

	@Override
	public void doUse(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("紧急，晚上使用金库！");
	}

	@Override
	public void doAlarm(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("按下警铃（晚上）");
	}

	@Override
	public void doPhone(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("晚上的通话录音");
	}

	@Override
	public String toString() {
		return "[晚上]";
	}

}
