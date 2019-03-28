package proxy;

/**
 * Main类（代码清单21-4）通过PrinterProxy类使用Printer类。
 * Main类首先会生成PrinterProxy，然后调用getPrinterName方法获取打印机名并显示它。
 * 之后通过setPrinterName方法重新设置打印机名。最后，调用print方法输出“Hel1o.world."。 示例程序的运行结果如图21-3所示。
 * 请注意，在设置名字和显示名字之间并没有生成Printer的实例（本人），直至调用print方法后，Printer的实例才被生成。
 * 
 * @author KANYUN
 *
 */
public class Main {
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("现在的名字是" + p.getPrinterName() + "。");
		p.setPrinterName("Bob");
		System.out.println("现在的名字是" + p.getPrinterName() + "。");
		p.print("Hello，world.");
	}
}
