package iterator;

/**
 * 书架类，由于需要将该类作为集合来处理，因此其实现了Aggregate接口
 * 
 * @author KANYUN
 *
 */
public class BookShelf implements Aggregate {
	private Book[] books;
	private int last = 0;

	public BookShelf(int maxSize) {
		// TODO Auto-generated constructor stub
		this.books = new Book[maxSize];
	}

	public Book getBookAt(int index) {
		return books[index];
	}

	public void appendBook(Book book) {
		this.books[last] = book;
		this.last++;
	}

	public int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new BookShelfIterator(this);
	}

}
