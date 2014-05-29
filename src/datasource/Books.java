package datasource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Books implements Iterable<Book> {
	private static Books instance = null;
	private static final ReentrantLock lock = new ReentrantLock();

	private List<Book> internalList = new ArrayList<Book>();

	private Books() {
		Book book = new Book("The wonderful world of planes", "A Pilot",
				"The history of planes from the Wright brothers through to modern day");
		internalList.add(book);
		book = new Book("The Hitchhikers Guide to the Galaxy", "Douglas Adams",
				"A book about a bunch of crazy stuff");
		internalList.add(book);
		book = new Book("Refactoring", "Martin Fowler",
				"All about refactoring, the how, the why, and other things");
		internalList.add(book);
		book = new Book("Good to Great", "Jim Collins",
				"Something about how to make things better");
		internalList.add(book);
		book = new Book("Clean Code", "Robert C Martin",
				"A handbook of agile software craftmanship");
		internalList.add(book);
		book = new Book("Design Patterns", "Gang of Four",
				"Elements of Reusable Object-Oriented Software");
		internalList.add(book);
		book = new Book("The mythical man month", "Frederick P Brooks Jr",
				"How throwing people at software doesn't make it go faster");
		internalList.add(book);
		book = new Book("The Pragmatic Programmer", "Andrew Hunt",
				"Something about being a clever developer");
		internalList.add(book);
	}

	public static Books getInstance() {
		if (instance == null) {
			lock.lock();
			if (instance == null) {
				instance = new Books();
			}
			lock.unlock();
		}
		return instance;
	}

	public int getCount() {
		return internalList.size();
	}

	public Book getBook(int index) {
		if (index < 0 || index > internalList.size()) {
			return null;
		}
		return internalList.get(index);
	}

	public List<Book> getAllBooks() {
		return internalList;
	}

	@Override
	public Iterator<Book> iterator() {
		return internalList.iterator();
	}
}

