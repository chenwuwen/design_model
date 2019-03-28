package composite;

/**
 * FileTreatMentException
 * 类（代码清单11-4）是对文件调用add方法时抛出的异常。该异常类并非Java类库的自带异常类，而是我们为本示例程序编写的异常类。
 * 
 * @author KANYUN
 *
 */
public class FileTreatmentException extends RuntimeException {

	public FileTreatmentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileTreatmentException() {
	}
}
