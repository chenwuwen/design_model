package strategy;

/**
 * Strategy接口（代码清单10-2）是定义了猜拳策略的抽象方法的接口。
 * nextlHand方法的作用是“获取下一局要出的手势”。调用该方法后，实现了Strategy接口的类会绞尽脑汁想出下一局出什么手势。
 * study方法的作用是学习“上一局的手势是否获胜了”。如果在上一局中调用nextHand方法获胜了，就接着调用study（true）；
 * 如果输了，就接着调用study（false）。这样，Strategy接口的实现类就会改变自己的内部状态，
 * 从而为下一次nextHand被调用时究竟是返回“石头”“剪刀”还是“布”提供判断依据。
 * 
 * @author KANYUN
 *
 */
public interface Strategy {
	
	public Hand nextHand();

	public void study(boolean win);
}
