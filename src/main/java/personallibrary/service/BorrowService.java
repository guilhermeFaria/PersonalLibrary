package personallibrary.service;

import java.util.List;

import personallibrary.model.Book;
import personallibrary.model.Borrow;

public interface BorrowService {

	/**
	 * Return all books borrowed
	 */
	public List<Borrow> getAllBorrowed();

	public List<Book> showBorrowedBooksByUser(final long userId);
	
	public void borrowedBook(final long bookId, final long userId);

	public void borrowedBookReturn(final long bookId);

}
