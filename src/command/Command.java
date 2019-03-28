package command;

/**
 * Command接口（代码清单22-1）是表示“命令”的接口。
 * 在该接口中只定义了一个方法，即execute（execute有“执行”的意思）。
 * 至于调用execute方法后具体会进行什么样的处理，则取决于实现了Command接口的类。总之，Command接口的作用就是“执行”什么东西。
 * 
 * @author KANYUN
 *
 */
public interface Command {
	public void execute();
}
