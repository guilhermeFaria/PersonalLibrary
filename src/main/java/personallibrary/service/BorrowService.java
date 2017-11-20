package personallibrary.service;

import java.util.List;

import personallibrary.model.Book;

public interface BorrowService {

	/**
	 * Return all books borrowed
	 */
	public List<Book> getAllBorrowed();

	public List<Book> showBorrowedBooksByUser(final long userId);
	
	public void borrowedBook(final long bookId, final long userId);

	public void borrowedBookReturn(final long bookId);

}
