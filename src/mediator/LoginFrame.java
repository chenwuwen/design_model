package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 现在,我们终于可以看看仲裁者的代码了。LoginFrame类(代码清单16-6)是java.awt.Frame(用于编写GUI程序的类)的子类,
 * 它实现了Mediator接口。 关于Java的AWT框架的内容已经超出了本书的范围,这里我们只学习与本章内容相关的重点知识。
 * LoginFrame类的构造函数进行了以下处理。 
 * ·设置背景色 
 * ·设置布局管理器(配置4(纵)×2(横)窗格) 
 * ·调用createcolleagues方法生成Colleague 
 * ·配置Colleague 
 * ·设置初始状态 
 * ·显示
 * createColleagues方法会生成登录对话框所需的Colleague,并将它们保存在LoginFrame类的字段中。
 * 此外,它还会调用每个Colleague的setMediator方法,事先告知它们“我是仲裁者,有什么问题的可以向我报告”。
 * createcolleagues方法还设置了各个 colleague的Listener。这样,AWT框架就可以调用合适的Listener了。
 * 整个示例程序中最重要的方法当属LoginFrame·类的colleagueChanged方法。
 * 该方法负责前面讲到过的“设置控件的启用/禁用的复杂逻辑处理”。
 * 请大家回忆一下之前学习过的Co1leagueButton、ColleagueCheckbox、ColleagueTextField等各个类。
 * 这些类中虽然都有设置自身的启用/禁用状态的方法,但是并没有“具体什么情况下需要设置启用/禁用”的逻辑处理。
 * 它们都只是简单地调用仲裁者的colleagueChanged方法告知仲裁者“剩下的就拜托给你了”。
 * 也就是说,所有最终的决定都是由仲裁者的colleaguechanged方法下达的。
 * 通过getstate方法可以获取单选按钮的状态,通过getText方法可以获取文本输入框中的文字。
 * 那么剩下的工作就是在colleagueChanged方法中实现之前学习过的那段复杂的控制逻辑处理了。
 * 此外,这里我们提取了一个共同的方法userpassChanged。该方法仅在LoginFrame类内部使用,其可见性为private。
 * 
 * @author KANYUN
 *
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleaqueTextField textUser;
	private ColleaqueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	/**
	 * 构造函数 生成并配置各个colleague后,显示对话框
	 */
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		// 使用布局管理器生成4×2窗格
		setLayout(new GridLayout(4, 2));
		// 生成各个Colleaque
		createColleagues();
		// 配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 设置初始的启用/禁用状态
		colleaguesChanged();
		// 显示
		pack();
		show();
	}

	/**
	 * 生成各个colleague
	 */
	@Override
	public void createColleagues() {
		// TODO Auto-generated method stub
		// 生成
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("togin", g, false);
		textUser = new ColleaqueTextField("", 10);
		textPass = new ColleaqueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// 设置Mediator
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// 设置Listener
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	/**
	 * 接收来自Colleague的通知然后判断各Colleague的启用/禁用状态
	 */
	@Override
	public void colleaguesChanged() {
		// TODO Auto-generated method stub
		if (checkGuest.getState()) { // Gueat mode
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		} else {// Login mode
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.toString());
		System.exit(0);
	}

	/**
	 * 当textuser或textPass文本输入框中的文字发生变化时 判断各Colleage的启用/禁用状态
	 */
	private void userpassChanged() {
		if (textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 0) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);

		}
	}
}
