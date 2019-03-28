package mediator;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * ColleaguerextField类（代码清单16-4）是java.awt.TextFie1d的子类，
 * 它不仅实现了Colleague接口，还实现了java.awt.event.TextListenex接口。
 * 这是因为我们希望通过textValueChanged方法捕捉到文本内容发生变化这一事件，并通知仲裁者。
 * 在Java语言中，我们虽然无法继承（extends）多个类，但是我们可以实现（implements）多个接口。
 * 在setColleagueEnab1ed方法中，我们不仅调用了setEnabled方法，还调用了setBackground方法。
 * 这是因为我们希望在启用控件后，将它的背景色改为白色；禁用控件后，将它的背景色改为灰色。
 * textValueChanged方法是在TextListener接口中定义的方法。 当文本内容发生变化时，AWT框架会调用该方法。
 * 在示例程序中，textValuechanged方法调用了colleaguechanged方法，
 * 这是在向仲裁者表达“对不起，文本内容有变化，请处理。”的意思。
 * 
 * @author KANYUN
 *
 */
public class ColleaqueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;

	/**
	 * 构造函数
	 * 
	 * @param text
	 * @param columns
	 * @throws HeadlessException
	 */
	public ColleaqueTextField(String text, int columns) throws HeadlessException {
		super(text, columns);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Mediator 下达启用/禁用 指示
	 */
	@Override
	public void setColleagueEnabled(Boolean enabled) {
		// TODO Auto-generated method stub
		setEnabled(enabled);
		setBackground(enabled ? Color.white : Color.lightGray);

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
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		mediator.colleaguesChanged();
	}

}
