package personallibrary.service;

import java.time.LocalDate;
import java.util.Date;
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
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	public void setBorrowRepository(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}
	
	@Override
	public List<Book> getAllBorrowed() {
		return borrowRepository.getAllBorrowed();
	}

	@Override
	public List<Book> showBorrowedBooksByUser(long userId) {
		return borrowRepository.findBorrowedBookByBUser(userId);
		
	}

	@Override
	public void borrowedBook(long bookId) {
		borrowRepository.save(new Borrow(bookId, 1, LocalDate.now(), setDateForReturn()));
	}

	@Override
	public void borrowedBookReturn(long bookId) {
		// TODO Auto-generated method stub
		
	}
	
	
	private LocalDate setDateForReturn() {
		//TODO Add Admin Service for configure the date set for Administrator
		LocalDate now = LocalDate.now();
		return now.plusDays(BORROWED_DAYS);
	}

}
