package command;

import java.awt.Point;

/**
 * Drawcommand类（代码清单22-3）实现了Command接口，表示“绘制一个点的命令”。
 * 在该类中有两个字段，即drawable和position。 drawable保存的是“绘制的对象”（我们会在稍后学习Drawable接口）；
 * position保存的是“绘制的位置”。point类是定义在java.awt包中的类，它表示由x轴和Y轴构成的平面上的坐标。
 * Drawcommand类的构造函数会接收两个参数，一个是实现了Drawab1e接口的类的实例，一个是Point类的实例，
 * 接收后会将它们分别保存在drawable字段和position字段中。它的作用是生成“在这个位置绘制点”的命令。 execute
 * 方法调用了drawable字段的draw方法。它的作用是执行命令。
 * 
 * @author KANYUN
 *
 */
public class DrawCommand implements Command {

	/**
	 * 绘制对象
	 */
	protected Drawable drawable;
	/**
	 * 绘制位置
	 */
	private Point position;

	/**
	 * 构造函数
	 */
	public DrawCommand(Drawable drawable, Point position) {
		super();
		this.drawable = drawable;
		this.position = position;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		drawable.draw(position.x, position.y);
	}

}
