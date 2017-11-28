package personallibrary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "AUT_AUTORIZATION")
public class Autorization implements GrantedAuthority {
	
	private static final long serialVersionUID = 85457305459785011L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AUT_ID")
	private Long id;
	
	@Column(name = "AUT_NAME", unique=true, length = 20, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return this.name;
	}
	
	public void setAuthority(String authority) {
		this.name = authority;
	}
		
}