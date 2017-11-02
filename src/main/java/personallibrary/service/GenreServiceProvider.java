package personallibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personallibrary.model.Genre;
import personallibrary.repository.GenreRepository;

@Service("genreService")
@Transactional
public class GenreServiceProvider implements GenreService {
	
	@Autowired
	public GenreRepository genreRepository;
	
	public void setGenreRepository(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	@Override
	public List<Genre> getAllGenres() {
		List<Genre> allGenre = new ArrayList<Genre>();
		for(Genre genre: genreRepository.findAll()) {
			allGenre.add(genre);
		}
		return allGenre;
	}

	@Override
	public List<Genre> searchGenre(String genreName) {
		return genreRepository.findByName(genreName);
	}

	@Override
	public void createGenre(Genre genre) {
		genreRepository.save(genre);

	}

	@Override
	public Genre searchIdGenre(Long id) {
		return genreRepository.findById(id);
	}

}
