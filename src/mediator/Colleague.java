package mediator;

/**
 * Colleague接口（代码清单16-2）是表示向仲裁者进行报告的组员的接口。
 * 具体的组员（ColleagueButton、ColleaguerextField、Colleaguecheckbox）会实现这个接口。
 * LoginFrame类实现了Mediator接口，它首先会调用setMediator方法。
 * 该方法的作用是告知组员“我是仲裁者，有事请报告我”。
 * 向该方法中传递的参数是仲裁者的实例，之后在需要向仲裁者报告时（即调用colleaguechanged方法时）会用到该实例。
 * setColleagueEnabled方法的作用是告知组员仲裁者所下达的指示。
 * 参数enabled如果为true，就表示自己需要变为“启用状态”；如果是false，则表示自己需要变为“禁用状态”。
 * 这个方法表明，究竟是变为“启用状态”还是变为“禁用状态”，并非由组员自己决定，而是由仲裁者来决定。
 * 此外需要说明的是，关于Mediator接口和Colleague接口中究竟需要定义哪些方法这一点，是根据需求不同而不同的。
 * 在示例程序中，我们在Mediator中定义了colleaguechanged方法，
 * 在Colleague接口中定义了setcolleagueEnabled方法。
 * 如果需要让Mediator角色和Colleague角色之间进行更加详细的通信，还需要定义更多的方法。
 * 也就是说，即使两段程序都使用了Mediator模式，但它们实际定义的方法可能会不同。
 * 
 * @author KANYUN
 *
 */
public interface Colleague {
	public void setColleagueEnabled(Boolean enabled);

	public void setMediator(Mediator mediator);
}
