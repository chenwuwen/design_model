package mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ColleagueCheckbox类（代码清单16-5）是java.awt.Checkbox的子类。
 * 在示例程序中，我们将其作为单选按钮使用，而没有将其作为勾选框使用（使用CheckboxGroup）。
 * 该类实现了java.awt.event.Itemlistener接口，这是因为我们希望通过itemSatechanged方法来捕获单选按钮的状态变化。
 * 
 * @author KANYUN
 *
 */
public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {

	private Mediator mediator;

	/**
	 * 构造函数
	 * 
	 * @param cpation
	 * @param group
	 * @param state
	 */
	public ColleagueCheckbox(String cpation, CheckboxGroup group, boolean state) {
		super(cpation, group, state);
	}

	/**
	 * Mediator 下达启用/禁用 指示
	 */
	@Override
	public void setColleagueEnabled(Boolean enabled) {
		// TODO Auto-generated method stub
		setEnabled(enabled);
	}

	/**
	 * 保存Mediator
	 */
	@Override
	public void setMediator(Mediator mediator) {
		// TODO Auto-generated method stub
		this.mediator = mediator;
	}

	/**
	 * 当文字发生变化时通知Mediator
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		mediator.colleaguesChanged();
	}

}
