package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SafeFrame类（代码清单19-7）是使用GUI实现警报系统界面的类（safe有“金库”的意思）。它实现了Context接口。
 * SafeFrame类中有表示文本输入框（TextField）、多行文本输入框（TextArea）和按钮（Button）等各种控件的字段。
 * 不过，也有一个不是表示控件的字段——state字段。它表示的是金库现在的状态，其初始值为“白天”状态。
 * SafeFrame类的构造函数进行了以下处理。
 * ·设置背景色 
 * ·设置布局管理器
 * ·设置控件 
 * ·设置监听器（Listener）
 * 监听器的设置非常重要，这里有必要稍微详细地了解一下。我们通过调用各个按钮的addActionListener方法来设置监听器。
 * addActionListener方法接收的参数是“当按钮被按下时会被调用的实例”，该实例必须是实现了ActionListener接口的实例。
 * 本例中，我们传递的参数是this，即SafeFrame类的实例自身（从代码中可以看到，SafeFrame类的确实现了ActionListener接口）。
 * “当按钮被按下后，监听器会被调用”这种程序结构类似于我们在第17章中学习过的Observer模式。
 * 当按钮被按下后，actionPerformed方法会被调用。该方法是在ActionListener（java.awt.event.ActionListener）接口中定义的方法，
 * 因此我们不能随意改变该方法的名称。在该方法中，我们会先判断当前哪个按钮被按下了，然后进行相应的处理。
 * 请注意，这里虽然出现了if语句，但是它是用来判断“按钮的种类”的，而并非用于判断“当前状态”。
 * 请不要将我们之前说过“使用State模式可以消除if语句”误认为是“程序中不会出现任何if语句”。
 * 处理的内容对State模式非常重要。例如，当金库使用按钮被按下时，以下语句会被执行。state.douse（this）；
 * 我们并没有先去判断当前时间是白天还是晚上，也没有判断金库的状态，而是直接调用了doUse方法。这就是State模式的特点。
 * 如果不使用State模式，这里就无法直接调用doUse方法，而是需要“根据时间状态来进行相应的处理”。
 * 在setClock方法中我们设置了当前时间。以下语句会将当前时间显示在标准输出中。
 *  System.out.print1n（clockstring）；
 * 以下语句则会将当前时间显示在textClock文本输入框（界面最上方）中。
 * textclock.setText（clockstring）；
 * 接着，下面的语句会进行当前状态下相应的处理（这时可能会发生状态迁移）。 
 * state.doclock（this，hour）；
 * changestate方法会调用Daystate类和Nightstate类。
 * 当发生状态迁移时，该方法会被调用。实际改变状态的是下面这条语句。
 * this.state=state；
 * 给代表状态的字段赋予表示当前状态的类的实例，就相当于进行了状态迁移。
 * ca11Securitycenter方法表示联系警报中心，
 * recordLog方法表示在警报中心留下记录。
 * 这里我们只是简单地在textScreen多行文本输入框中增加代表记录的文字信息。真实情况下，这里应当访问警报中心的网络进行一些处理。
 * 
 * @author KANYUN
 *
 */
public class SafeFrame extends Frame implements ActionListener, Context {
	/**
	 * 显示当前时间
	 */
	private TextField textClock = new TextField(60);
	/**
	 * 显示警报中心记录
	 */
	private TextArea textScreen = new TextArea(10, 60);
	/**
	 * 使用金库按钮
	 */
	private Button buttonUse = new Button("使用金库");

	/**
	 * 按下警铃按钮
	 */
	private Button buttonAlarm = new Button("按下警铃");
	/**
	 * 正常通话按钮
	 */
	private Button buttonPhone = new Button("正常通话");
	/**
	 * 结束按钮
	 */
	private Button buttonExit = new Button("结束");

	/**
	 * 当前状态
	 */
	private State state = DayState.getInstance();

	public SafeFrame(String title) throws HeadlessException {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		// 配置textClock
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		// 配置textScreen
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		// 为界面添加按钮
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		// 配置界面
		add(panel, BorderLayout.SOUTH);
		// 显示
		pack();
		show();
		// 设置监听器
		buttonUse.addActionListener(this);
		buttonUse.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	/**
	 * 按下按钮后该方法会被调用
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if (e.getSource() == buttonUse) {// 金库使用按钮
			state.doUse(this);

		} else if (e.getSource() == buttonAlarm) {// 按下警铃按钮
			state.doAlarm(this);
		} else if (e.getSource() == buttonPhone) {// 正常通话按钮
			state.doPhone(this);
		} else if (e.getSource() == buttonExit) {// 结束按钮
			System.exit(0);
		} else {
			System.out.println("?");
		}
	}

	/**
	 * 设置时间
	 */
	@Override
	public void setClock(int hour) {
		// TODO Auto-generated method stub
		String clockstring = "现在时间是：";
		if (hour < 10) {
			clockstring += "0" + hour + ":00";
		} else {
			clockstring += hour + ":00";
		}
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);

	}

	/**
	 * 改变状态
	 */
	@Override
	public void changeSate(State state) {
		// TODO Auto-generated method stub
		System.out.println("从" + this.state + "状态变为了" + state + "状态");
		this.state = state;

	}

	/**
	 * 联系警报中心
	 */
	@Override
	public void callSecurityCenter(String msg) {
		// TODO Auto-generated method stub
		textScreen.append("calling " + msg + "\n");
	}

	/**
	 * 在警报中心留下记录
	 */
	@Override
	public void recordLog(String msg) {
		// TODO Auto-generated method stub
		textScreen.append("recording " + msg + "\n");
	}

}
