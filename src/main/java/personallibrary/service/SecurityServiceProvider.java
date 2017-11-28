package personallibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import personallibrary.model.User;
import personallibrary.repository.UserRepository;

@Service("securityService")
public class SecurityServiceProvider implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
	
	
}
