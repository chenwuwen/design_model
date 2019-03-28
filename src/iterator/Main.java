package iterator;

public class Main {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Mysql从删除到跑路"));
		bookShelf.appendBook(new Book("C++从入门到放弃"));
		bookShelf.appendBook(new Book("JAVA从精通到陌生"));
		bookShelf.appendBook(new Book("PHP从看懂到看开"));
		Iterator iterator = bookShelf.iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.getName());
		}
	}
}
