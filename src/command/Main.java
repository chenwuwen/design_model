package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Main类(代码清单22-6)是启动应用程序的类。
 * 在history字段中保存的是绘制历史记录。它会被传递给Drawcanvas的实例。也就是说,Main类的实例与DrawCanvas类的实例共享绘制历史记录。
 * canvas字段表示绘制区域。它的初始值是400×400。 clearButton字段是用于删除已绘制圆点的按钮。
 * JButton类是在javax.swing包中定义的按钮类。
 * Main类的构造函数中设置了用于接收鼠标按下等事件的监听器(listener),并安排了各个控件(组件)在界面中的布局。
 * 为了便于大家在解答本章习题时扩展程序,这里我们将按钮的布局稍微弄得复杂了些。 首先,我们设置了一个用于横向放置控件的buttonBox按钮盒。
 * 请注意,为了可以在里面横向放置控件,我们在调用它的构造函数时传递了参数BoxLayout.X_AXIS。
 * 接着,我们在buttonBox中放置了一个clearButton。
 * 然后,又设置了一个用于纵向放置控件的按钮盒mainBox,并将buttonBox和canvas置于其中。
 * 最后,我们将mainBox置于JFrame中。也可以直接在java.awt.JErame中放置控件,
 * 不过如果是在javax.swing.JFrame中,则必须将控件放置在通过 getcontentPane方法获取的容器之内(图22-3)。 Main
 * 类实现了ActionListener接口中的actionPerformed方法。clearButton被按下后会清空所有绘制历史记录,然后重新绘制
 * canvas。 Main类还实现了在MouseMotionListener接口中的mouseMoved方法和mouseDragged方法。
 * 当鼠标被拖动时(mouseDragged),会生成一条“在这个位置画点”的命令。
 * 该命令会先被添加至绘制历史记录中。history.append(cmd);然后立即执行。cmd,execute();
 * Main类还实现了在WindowListener中定义的那些以window开头的方法。除了退出处理的方法(exit)外,其他方法什么都不做。
 * main方法中生成了Main类的实例,启动了应用程序。
 * 
 * @author KANYUN
 *
 */
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

	/**
	 * 绘制的历史记录
	 */
	private MacroCommand history = new MacroCommand();
	/**
	 * 绘制区域
	 */
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	/**
	 * 删除按钮
	 */
	private JButton clearButton = new JButton("clear");

	/**
	 * 构造函数
	 * 
	 * @param title
	 */
	public Main(String title) {
		super(title);

		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);

		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		pack();
		show();
	}

	/**
	 * ActionListener接口中的方法
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
	}

	/**
	 * MouseMotiontistener接口中的方法
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}

	/**
	 * windowListener接口中的方法
	 * 
	 * @param e
	 */
	public void windowclosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}
