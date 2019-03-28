package facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Database类（代码清单15-1）可获取指定数据库名（如maildata）所对应的Properties的实例。
 * 我们无法生成该类的任何实例，只能通过它的getProperties静态方法获取Properties的实例。代码清单15-2是数据库的一个示例。
 * 这里的数据库指的是一个记录了几条数据的文本，并非编程中常用的关系数据库。
 * 
 * @author KANYUN
 *
 */
public class Database {

	private Database() {
	}

	public static Properties getProperties(String dbName) {
		String fileName = dbName + ".txt";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Warning: " + fileName + " is not found");
		}

		return prop;

	}
}
