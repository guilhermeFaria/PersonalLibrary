package personallibrary.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personallibrary.model.Book;
import personallibrary.model.Borrow;
import personallibrary.repository.BorrowRepository;

@Service("borrowService")
@Transactional
public class BorrowServiceProvider implements BorrowService {
	
	private static final int BORROWED_DAYS = 7;
	private static final String LOAN_INITIAL_STATE = "BORROWED";
	
	@Autowired
	public BorrowRepository borrowRepository;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	public void setBorrowRepository(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}
	
	@Override
	public List<Book> getAllBorrowed() {
		//return borrowRepository.getAllBorrowed();
		return new ArrayList<Book>();
	}

	@Override
	public List<Book> showBorrowedBooksByUser(final long userId) {
		//return borrowRepository.findBorrowedBookByBUser(userId);
		return new ArrayList<Book>();
		
	}

	@Override
	public void borrowedBook(final long bookId, final long userId) {
		final Borrow borrowedBook = new Borrow(LOAN_INITIAL_STATE, LocalDate.now(), setDateForReturn(), bookService.searchBookId(bookId), userService.searchUserId(userId));
		borrowRepository.save(borrowedBook);		
	}

	@Override
	public void borrowedBookReturn(final long bookId) {
		// TODO Auto-generated method stub
		
	}
	
	
	private LocalDate setDateForReturn() {
		//TODO Add Admin Service for configure the date set for Administrator
		LocalDate now = LocalDate.now();
		return now.plusDays(BORROWED_DAYS);
	}

}
