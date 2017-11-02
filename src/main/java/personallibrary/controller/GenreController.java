package personallibrary.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import personallibrary.model.Genre;
import personallibrary.service.GenreService;

@RestController
@RequestMapping (value = "/genre")
public class GenreController {
	
	@Autowired
	public GenreService genreService;
	
	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	@RequestMapping(value= "/searchId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Genre> searchId(@PathVariable("id") final Long id) {
		return new ResponseEntity<Genre>(genreService.searchIdGenre(id), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/search/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Genre>> search(@PathVariable("name") final String name) {
		return new ResponseEntity<Collection<Genre>>(genreService.searchGenre(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Genre>> getAll() {
		return new ResponseEntity<Collection<Genre>>(genreService.getAllGenres(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public HttpStatus createGenre(@RequestBody final Genre genre) {
		genreService.createGenre(genre);
		return HttpStatus.CREATED;
	}
	
}