package personallibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import personallibrary.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	public List<Book> findByNameContaining(final String name);
	
	public Book findById(final Long id);
	
	public List<Book> findByGenre(final String genreName);
	
}
