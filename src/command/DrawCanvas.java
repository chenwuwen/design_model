package command;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * DrawCanvas类(代码清单22-5)实现了Drawable接口,它是java.awt.Canvas的子类。
 * 在history字段中保存的是Drawcanvas类自己应当执行的绘制命令的集合。该字段是command.Macrocommand类型的。
 * DrawCanvas类的构造函数使用接收到的宽(width)、高(height)和绘制内容(history)去初始化Drawcanvas类的实例。
 * 在构造函数内部被调用的setsize方法和setBackground方法是java.awt.Canvas的方法,它们的作用分别是指定大小和背景色。
 * 当需要重新绘制DrawCanvas时,Java处理(java.awt的框架)会调用print方法。它所做的事情仅仅是调用history.execute方法。
 * 这样,记录在history中的所有历史命令都会被重新执行一遍。
 * draw方法是为了实现Drawable接口而定义的方法。DrawCanvas类实现了该方法,它会调用g.setcolor
 * 指定颜色,调用g.fillOva1画圆点。
 * 
 * @author KANYUN
 *
 */
public class DrawCanvas extends Canvas implements Drawable {

	/**
	 * 颜色
	 */
	private Color color = Color.red;
	/**
	 * 要绘制的圆点的半径
	 */
	private int radius = 6;
	/**
	 * 命令的历史记录
	 */
	private MacroCommand history;

	/**
	 * 构造函数
	 * 
	 * @param width
	 * @param height
	 * @param history
	 */
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	/**
	 * 重新全部绘制
	 */
	public void paint(Graphics g) {
		history.execute();
	}

	/**
	 * 绘制
	 */
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

}
