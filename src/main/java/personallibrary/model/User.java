package personallibrary.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import personallibrary.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="USR_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USR_ID")
	@JsonView({View.All.class, View.Alternative.class})
	private Long id;
	
	@Column(name = "USR_NAME", length = 50, nullable = false)
	@JsonView({View.Main.class, View.UsuarioSimples.class})
	private String name;
	
	@Column(name="USR_PASSWORD", length=50, nullable=false)
	@JsonView(View.All.class)
	private String password;
	
	@Column(name = "USR_EMAIL", unique=true, length = 50, nullable = false)
	@JsonView({View.Main.class, View.UsuarioSimples.class})
	private String email;
		
	@OneToMany(mappedBy = "user", targetEntity=Borrow.class, fetch = FetchType.EAGER)
	@JsonView({View.Main.class, View.UsuarioSimples.class})
	private Set<Borrow> locations;
/*	
	public User(final String name, final String password, final String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		locations = new ArrayList<Borrow>();
	}
	
	public User() {
		
	}
*/	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Borrow> getLocations() {
		return locations;
	}

	public void setLocations(Set<Borrow> locations) {
		this.locations = locations;
	}	
}