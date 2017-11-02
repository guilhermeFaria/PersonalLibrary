package personallibrary.service;

import java.util.List;

import personallibrary.model.Genre;

public interface GenreService {
	
	public List<Genre> getAllGenres();
	
	public List<Genre> searchGenre(final String name);
	
	public void createGenre(final Genre Genre);

	public Genre searchIdGenre(Long id);

}
