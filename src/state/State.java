package state;

import state.Context;

/**
 * State接口（代码清单19-3）是表示金库状态的接口。
 * 在State接口中定义了以下事件对应的接口（APl）。 
 * ·设置时间
 * ·使用金库
 * ·按下警铃
 * ·正常通话
 * 以上这些接口（APl）分别对应我们之前在伪代码中编写的“使用金库时被调用的方法”等方法。
 * 这些方法的处理都会根据状态不同而不同。可以说，State接口是一个依赖于状态的方法的集合。
 * 这些方法接收的参数Context是管理状态的接口。关于Context接口的内容我们会在稍后进行学习。
 * 
 * @author KANYUN
 *
 */
public interface State {
	/**
	 * 设置时间
	 * 
	 * @param context
	 */
	public void doClock(Context context, int hour);

	/**
	 * 使用金库
	 * 
	 * @param context
	 */
	public void doUse(Context context);

	/**
	 * 按下警铃
	 * 
	 * @param context
	 */
	public void doAlarm(Context context);

	/**
	 * 正常通话
	 * 
	 * @param context
	 */
	public void doPhone(Context context);
}