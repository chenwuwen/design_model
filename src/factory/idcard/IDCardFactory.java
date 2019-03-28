package factory.idcard;

import java.util.ArrayList;
import java.util.List;

import factory.framework.Factory;
import factory.framework.Product;

/**
 * IDCardFactory类（代码清单4-4）实现了createProduct方法和registerProduct方法。
 * createProduct方法通过生成IDCard的实例来“生产产品”。
 * registerProduct方法则通过将IDCard的owner（持有人）保存到owners字段中来实现“注册产品”。
 * 
 * @author KANYUN
 *
 */
public class IDCardFactory extends Factory {

	private List owners = new ArrayList<>();

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		owners.add(product);

	}

	@Override
	protected Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return new IDCard(owner);
	}

	public List getOwners() {
		return owners;
	}

}
