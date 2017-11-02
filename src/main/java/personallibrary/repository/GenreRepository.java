package personallibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import personallibrary.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	
	public List<Genre> findByName(final String genreName);
	
	public Genre findById(final Long id);
	
	
}