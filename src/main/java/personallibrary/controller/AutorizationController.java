package personallibrary.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personallibrary.model.Autorization;
import personallibrary.service.AutorizationService;

@RestController
public class AutorizationController {
	
	
	@Autowired
	private AutorizationService autorizationService;
	
	public void setAutorizationService(AutorizationService autorizationService) {
		this.autorizationService = autorizationService;
	}
	
	@RequestMapping(value = "/autorization/{name}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Collection<Autorization>> pesquisar(@PathVariable("name") String name) {
		return new ResponseEntity<Collection<Autorization>>(autorizationService.search(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autorization/getAll")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Collection<Autorization>> getAll() {
		return new ResponseEntity<Collection<Autorization>>(autorizationService.getAll(), HttpStatus.OK);
	}	
}