package personallibrary.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import personallibrary.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="USR_USER")
public class User implements UserDetails {
	
	private static final long serialVersionUID = -5435563756171980752L;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "UAU_USER_AUTORIZATION",
			joinColumns = { @JoinColumn(name = "USR_ID")},
			inverseJoinColumns = { @JoinColumn(name = "AUT_ID") })
	private List<Autorization> autorizations;

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

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Borrow> getLocations() {
		return locations;
	}

	public void setLocations(Set<Borrow> locations) {
		this.locations = locations;
	}

	public List<Autorization> getAutorizations() {
		return autorizations;
	}

	public void setAutorizations(List<Autorization> autorizations) {
		this.autorizations = autorizations;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.autorizations;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		return name;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}	
}