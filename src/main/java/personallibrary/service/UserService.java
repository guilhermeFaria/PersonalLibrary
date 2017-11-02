package personallibrary.service;

import java.util.List;

import personallibrary.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	/**
	 * Do a user search by name
	 *  
	 * @param String name of user
	 * @return a list of users search
	 */
	public List<User> searchUser(final String name);
	
	public User searchUserId (final Long id);
	
	public void create(final User user);
	
	public void delete(final User user);
	
	public void update(final User user);
	
}