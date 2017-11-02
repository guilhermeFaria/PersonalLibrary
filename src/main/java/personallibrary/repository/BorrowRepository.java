package personallibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import personallibrary.model.Book;
import personallibrary.model.Borrow;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {
	
	@Query("select book.bk_name, book.bk_isbn, book.bk_writer "
			+ "from BK_BOOK book "
			+ "where book.bk_id in ((select borrow.bk_id from BRW_BORROW borrow))")
	public List<Book> findBorrowedBookByBUser(Long userId);
	
	@Query("select book.bk_name, book.bk_isbn, book.bk_writer "
			+ "from BK_BOOK book "
			+ "where book.bk_id in ((select borrow.bk_id from BRW_BORROW borrow))")
	public List<Book> getAllBorrowed();
	
	
}
