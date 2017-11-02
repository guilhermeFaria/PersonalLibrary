package personallibrary.service;

import java.util.List;

import personallibrary.model.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public List<Book> searchBook(final String name);
	
	public void create(final Book book);

	public Book searchBookId(Long id);
	
	public void delete(final Book book);
	
	public void update(final Book book);
	
}
