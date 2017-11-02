package personallibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personallibrary.model.Book;
import personallibrary.repository.BookRepository;

@Service("bookService")
@Transactional
public class BookServiceProvider implements BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = new ArrayList<Book>();
		for(Book book: bookRepository.findAll()) {
			allBooks.add(book);
		}
		return allBooks;
	}
	
	@Override
	public List<Book> searchBook(final String name) {
		return bookRepository.findByNameContaining(name);
	}
	
	@Override
	public Book searchBookId(final Long id) {
		return bookRepository.findById(id);
	}
	
	@Override
	public void create(final Book book) {
		bookRepository.save(book);
	}
	
	@Override
	public void delete(final Book book) {
		bookRepository.delete(book);
	}
	
	@Override
	public void update(final Book book) {
		bookRepository.save(book);
	}	

}
