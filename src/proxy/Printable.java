package proxy;

/**
 * Printable接口(代码清单21-2)用于使PrinterProxy类和Printer类具有一致性。
 * setPrinterName方法用于设置打印机的名字;
 * getPrinterName用于获取打印机的名字;
 * print用于显示文字(打印输出)。
 * 
 * @author KANYUN
 *
 */
public interface Printable {
	/**
	 * 设置名字
	 * 
	 * @param name
	 */
	public void setPrinterName(String name);

	/**
	 * 获取名字
	 * 
	 * @return
	 */
	public String getPrinterName();

	/**
	 * 显示文字(打印输出)
	 * 
	 * @param string
	 */
	public void print(String string);
}
