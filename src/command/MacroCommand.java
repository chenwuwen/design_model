package command;

import java.util.Iterator;
import java.util.Stack;

/**
 * MacroCommand类（代码清单21-2）表示“由多条命令整合成的命令”。该类实现了Command接口。
 * Macrocommand中的Macro有“大量的”的意思，在编程中，它一般表示“由多条命令整合成的命令”。
 * MacroCommand类的commands字段是java.uti1.Stack类型的，
 * 它是保存了多个Command（实现了Command接口的类的实例）的集合。
 * 虽然这里也可以使用java.util.ArrayList类型，不过后文中会提到，为了能轻松地实现undo方法，我们还是决定使用java.uti1.Stack类型。
 * 由于MacroCommand类实现了Command接口，因此在它内部也定义了execute方法。
 * 那么execute方法应该进行什么处理呢？既然要运行多条命令，那么只调用commands字段中各个实例的execute方法不就可以了吗？
 * 这样，就可以将Macrocommand自己保存的所有Command全部执行一遍。
 * 不过，如果while循环中要执行的Command又是另外一个MacroCommand类的实例呢？
 * 这时，该实例中的execute方法也是会被调用的。因此，最后的结果就是所有的Command全部都会被执行。
 * append方法用于向Macrocommand类中添加新的Command（所谓“添加新的Command”是指添加新的实现（implements）了Command接口的类的实例）。
 * 新增加的Command也可能是Macrocommand类的实例。 这里的if语句的作用是防止不小心将自己（this）添加进去。
 * 如果这么做了，execute方法将会陷入死循环，永远不停地执行。
 * 这里我们使用了java.util.Stack类的push方法，它会将元素添加至java.util.Stack类的实例的末尾。
 * undo方法用于删除commands中的最后一条命令。
 * 这里我们使用了java.util.Stack类的pop方法，它会将push方法添加的最后一条命令取出来。被取出的命令将会从Stack类的实例中被移除。
 * clear方法用于删除所有命令。
 * 
 * @author KANYUN
 *
 */
public class MacroCommand implements Command {

	/**
	 * 命令集合
	 */
	private Stack commands = new Stack<>();

	/**
	 * 执行
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Iterator iterator = commands.iterator();
		while (iterator.hasNext()) {
			((MacroCommand) iterator.next()).execute();

		}
	}

	/**
	 * 添加一条命令
	 * 
	 * @param cmd
	 */
	public void append(Command cmd) {
		// TODO Auto-generated method stub
		if (cmd != this) {
			commands.push(cmd);
		}
	}

	/**
	 * 删除最后一条命令
	 */
	public void undo() {
		if (!commands.empty()) {
			commands.pop();
		}
	}

	/**
	 * 删除所有命令
	 */
	public void clear() {
		commands.clear();
	}
}
