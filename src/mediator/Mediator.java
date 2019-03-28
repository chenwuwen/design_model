package mediator;

/**
 * Mediator接口（代码清单16-1）是表示仲裁者的接口。具体的仲裁者（后文中即将学习的LoginFrame类）会实现这个接口。
 * createColleagues方法用于生成Mediator要管理的组员。
 * 在示例程序中，createColleagues会生成对话框中的按钮和文本输入框等控件。
 * colleaguechanged方法会被各个Colleague组员调用。
 * 它的作用是让组员可以向仲裁者进行报告。在本例中，当单选按钮和文本输入框的状态发生变化时，该方法会被调用。
 * 
 * 
 * @author KANYUN
 *
 */
public interface Mediator {
	public void createColleagues();

	public void colleaguesChanged();
}
