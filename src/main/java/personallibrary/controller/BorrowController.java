package personallibrary.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personallibrary.model.Book;
import personallibrary.service.BorrowService;

@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {

	@Autowired
	private BorrowService borrowService;
	
	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Book>> getAllBorrowed() {
		return new ResponseEntity<Collection<Book>>(borrowService.getAllBorrowed(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/show/book/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Book>> showBorrowedBooksByUser(@PathVariable ("userId") final long userId) {		
		return new ResponseEntity<Collection<Book>>(borrowService.showBorrowedBooksByUser(userId), HttpStatus.OK);
	}
	
	
	/**
	 * TODO Confirm the return of method
	 * Borrowed book
	 * @param bookId The id of book
	 * @return 
	 */
	@CrossOrigin
	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> borrowedBook(@PathVariable ("bookId") final long bookId) {
		borrowService.borrowedBook(bookId);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/book/return/{bookId}", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> borrowedBookReturn(@PathVariable ("bookId") final long bookId) {
		borrowService.borrowedBookReturn(bookId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}