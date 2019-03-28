package composite;

/**
 * Main类（代码清单11-5）将使用以上的类建成下面这样的文件夹结构。在Main类中，我们首先新建
 * root文件夹，再在root文件夹下建立bin、tmp、usr这3个文件夹，然后在bin文件夹中放入vi文件和latex文件。
 * 接着，我们在usr文件夹下新建yuki、hanako、tomura这个文件夹，然后将这3个用户各自的文件分别放入到这些文件夹中。
 * 运行结果如图11-2所示。请注意，在放入了各用户的文件后，root文件夹变大了。
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
			rootdir.printList();
			
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
			rootdir.printList();
		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}

	}
}
