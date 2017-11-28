package personallibrary.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import personallibrary.model.Book;
import personallibrary.service.BookService;
import personallibrary.view.View;

@RestController
@CrossOrigin
@RequestMapping (value = "/book")
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value= "/searchId/{id}", method = RequestMethod.GET)
	@JsonView(View.Main.class)
	public ResponseEntity<Book> search(@PathVariable("id") final Long id) {
		return new ResponseEntity<Book>(bookService.searchBookId(id), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/search/{name}", method = RequestMethod.GET)
	@JsonView(View.Main.class)
	public ResponseEntity<Collection<Book>> search(@PathVariable("name") final String name) {
		return new ResponseEntity<Collection<Book>>(bookService.searchBook(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@JsonView(View.Main.class)
	public ResponseEntity<Collection<Book>> getAll() {
		return new ResponseEntity<Collection<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@JsonView(View.Main.class)
	@PreAuthorize("hasRole('ROLE_BASIC_USER')")
	public ResponseEntity<HttpStatus> createBook(@RequestBody final Book book) {
		bookService.create(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@JsonView(View.Main.class)
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<HttpStatus> updateBook(@RequestBody final Book book) {
		bookService.update(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@JsonView(View.Main.class)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<HttpStatus> deleteBook(@RequestBody final Book book) {
		bookService.delete(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}