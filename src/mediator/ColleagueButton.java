package mediator;

import java.awt.Button;

/**
 * ColleagueButton类（代码清单16-3）是java.awt.Button的子类，它实现了Colleague接口，
 * 与LoginFrame（Mediator接口）共同工作。
 * mediator字段中保存了通过setMediator方法的参数传递进来的Mediator对象（LoginErame类的实例）。
 * setcolleagueEnabled方法会调用Java的GUI中定义的setEnabled方法，设置禁用或是启用控件。
 * setEnabled（true）后控件按钮可以被按下，setEnabled（false）后按钮无法被按下。
 * 
 * @author KANYUN
 *
 */
public class ColleagueButton extends Button implements Colleague {

	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
	}

	@Override
	public void setColleagueEnabled(Boolean enabled) {
		// TODO Auto-generated method stub
		setEnabled(enabled);
	}

	@Override
	public void setMediator(Mediator mediator) {
		// TODO Auto-generated method stub
		this.mediator = mediator;
	}

}
