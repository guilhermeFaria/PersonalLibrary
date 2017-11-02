package personallibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import personallibrary.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findByNameContaining(final String name);
	
	public User findById(final Long id);
	
}
