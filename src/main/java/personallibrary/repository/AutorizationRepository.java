package personallibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import personallibrary.model.Autorization;

public interface AutorizationRepository extends CrudRepository<Autorization, Long> {
	
	public List<Autorization> findByNameContainsIgnoreCase(String name);
	
}
