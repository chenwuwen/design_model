package command;

/**
 * Drawable接口（代码清单22-4）是表示“绘制对象”的接口。draw方法是用于绘制的方法。
 * 在示例程序中，我们尽量让需求简单一点，因此暂时不考虑指定点的颜色和点的大小。关于指定点的颜色的问题，我们会在习题22-1中讨论。
 * 
 * @author KANYUN
 *
 */
public interface Drawable {
	public void draw(int x, int y);
}
