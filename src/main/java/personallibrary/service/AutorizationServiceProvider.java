package personallibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import personallibrary.model.Autorization;
import personallibrary.repository.AutorizationRepository;

@Service("autorizationService")
@Transactional
public class AutorizationServiceProvider implements AutorizationService {

	@Autowired
	private AutorizationRepository autorizationRepository;
	
	public void setAutorizationRepository(AutorizationRepository autorizationRepository) {
		this.autorizationRepository = autorizationRepository;
	}
	
	@Override
	public Autorization salvar(Autorization autorization) {
		return autorizationRepository.save(autorization);
	}

	@Override
	public void excluir(Long idAutorization) {
		autorizationRepository.delete(idAutorization);
	}

	@Override
	public List<Autorization> getAll() {
		List<Autorization> autorizations = new ArrayList<Autorization>();
		for(Autorization autorization: autorizationRepository.findAll()) {
			autorizations.add(autorization);
		}
		return autorizations;
	}

	@Override
	public List<Autorization> search(String name) {
		if(name == null || name.isEmpty()) {
			return getAll();
		}
		return autorizationRepository.findByNameContainsIgnoreCase(name);
	}

	@Override
	public Autorization buscarPorId(Long idAutorization) {
		return autorizationRepository.findOne(idAutorization);
	}

}
