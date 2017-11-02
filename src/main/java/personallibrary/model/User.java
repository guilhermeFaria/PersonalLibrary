package personallibrary.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
		
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BRW_BORROW", 
    	joinColumns = { @JoinColumn(name = "USR_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "BK_ID") })
    @JsonView({View.Main.class, View.Alternative.class})
    @XmlElement(name = "book") 
	private List<Book> locations;
	
	public User(final String name, final String password, final String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public User() {
		
	}
	
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

	public List<Book> getLocations() {
		return locations;
	}

	public void setLocations(List<Book> locations) {
		this.locations = locations;
	}	
}