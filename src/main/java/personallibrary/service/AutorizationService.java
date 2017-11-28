package personallibrary.service;

import java.util.List;

import personallibrary.model.Autorization;

public interface AutorizationService {
	
	public Autorization salvar(final Autorization autorization);
	
	public void excluir(final Long idAutorization);
	
	public List<Autorization> getAll();
	
	public List<Autorization> search(final String name);
	
	public Autorization buscarPorId(final Long idAutorization);

}
