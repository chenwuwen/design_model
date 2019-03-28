package state;

/**
 * Context接口（代码清单19-6）是负责管理状态和联系警报中心的接口。我们将在学习
 * “safeFrame类”时结合代码清单19-7学习它实际进行了哪些处理。
 * 
 * @author KANYUN
 *
 */
public interface Context {
	/**
	 * 设置时间
	 * 
	 * @param hour
	 */
	public void setClock(int hour);

	/**
	 * 改变状态
	 * 
	 * @param hour
	 */
	public void changeSate(State state);

	/**
	 * 联系警报中心
	 * 
	 * @param hour
	 */
	public void callSecurityCenter(String msg);

	/**
	 * 在警报中心留下记录
	 * 
	 * @param hour
	 */
	public void recordLog(String msg);
}
