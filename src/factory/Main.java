package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCard;
import factory.idcard.IDCardFactory;

public class Main {
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = new IDCard("看云");
		Product card2 = new IDCard("无问");
		Product card3 = new IDCard("方寸");
		Product card4 = new IDCard("东方");
		card1.use();
		card2.use();
		card3.use();
		card4.use();
	}
}
