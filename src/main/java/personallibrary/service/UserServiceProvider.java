package personallibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personallibrary.model.User;
import personallibrary.repository.UserRepository;
import personallibrary.validate.UserValidate;

@Service("userService")
@Transactional
public class UserServiceProvider implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		for(User user: userRepository.findAll()) {
			allUsers.add(user);
		}
		return allUsers;
	}
	
	@Override
	public List<User> searchUser(final String name) {
		return userRepository.findByNameContaining(name);
	}
	
	@Override
	public User searchUserId(final Long id) {
		return userRepository.findById(id);
	}
	@Override
	public void create(final User user) {
		try {
			UserValidate.validateCreateUser(user);
			userRepository.save(user);
		} catch (Throwable exception) {
			exception.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(final User user) {
		userRepository.delete(user);
	}
	
	@Override
	public void update(final User user) {
		userRepository.save(user);
	}

}