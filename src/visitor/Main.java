package visitor;

import visitor.Directory;
import visitor.File;
import visitor.FileTreatmentException;

/**
 * Main类（代码清单13-8）与Composite模式中的Main类基本相同。
 * 不同之处仅仅在于，本章中的Main类使用了访问者ListVisitor类的实例来显示Directory中的内容。
 * 在Composite模式中，我们调用printList方法来显示文件夹中的内容。
 * 该方法已经在Directory类（即表示数据结构的类）中被实现了。
 * 与之相对，在Visitor模式中是在访问者中显示文件夹中的内容。这是因为显示文件夹中的内容也属于对数据结构中的各元素进行的处理。
 * 
 * @author KANYUN
 *
 */
public class Main {
public static void main(String[] args) {
	try {
		System.out.println("Making root entries..…");
		Directory rootdir = new Directory("root");
		Directory bindir = new Directory("bin");
		Directory tmpdir = new Directory("tmp");
		Directory usrdir = new Directory("usr");
		rootdir.add(bindir);
		rootdir.add(tmpdir);
		rootdir.add(usrdir);
		bindir.add(new File("vi", 10000));
		bindir.add(new File("latex", 20000));
		rootdir.accept(new ListVisitor());
		
		System.out.println("");
		System.out.println("Making user entries...");
		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");
		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);
		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composite.java", 200));
		hanako.add(new File("memo.tex", 300));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));
		rootdir.accept(new ListVisitor());
	} catch (FileTreatmentException e) {
		e.printStackTrace();
	}
}
}
