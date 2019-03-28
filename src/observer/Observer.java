package observer;

/**
 * observer接口（代码清单17-1）是表示“观察者”的接口。具体的观察者会实现这个接口。
 * 需要注意的是，这个observer接口是为了便于我们了解observer的示例程序而编写的，
 * 它与Java类库中的ava.uti1.observer接口不同。它们之间的详细区别请参见本章17.5节。
 * 用于生成数值的NumberGenerator 类会调用update方法。Generator有“生成器”“产生器”的意思。
 * 如果调用update方法，NumberGenerator类就会将“生成的数值发生了变化，请更新显示内容”的通知发送给Observer。
 * 
 * @author KANYUN
 *
 */
public interface Observer {
	public void update(NumberGenerator numberGenerator);
}
