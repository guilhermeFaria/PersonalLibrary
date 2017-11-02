package personallibrary.service;

import java.util.List;

import personallibrary.model.Book;

public interface BorrowService {

	/**
	 * Return all books borrowed
	 */
	public List<Book> getAllBorrowed();

	public List<Book> showBorrowedBooksByUser(long userId);
	
	public void borrowedBook(long bookId);

	public void borrowedBookReturn(long bookId);

}
