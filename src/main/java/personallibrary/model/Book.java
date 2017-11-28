package personallibrary.model;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import personallibrary.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="BK_BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BK_ID")
	@JsonView(View.All.class)
	private Long id;
	
	@Column(name="BK_NAME", unique=true, length=50, nullable=false)
	@JsonView({View.Main.class})
	private String name;
	
	@Column(name="BK_ISBN", unique=true, length=20)
	@JsonView({View.Main.class})
	private String isbn;
	
	@Column(name="BK_WRITER", unique=true, length=50)
	@JsonView({View.Main.class})
	private String writer;
	
	@OneToMany(mappedBy="book", targetEntity = Borrow.class, fetch = FetchType.EAGER)
    @JsonView({View.Main.class})
	private Set<Borrow> locations;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BKGR_BOOK_GENRE", 
    	joinColumns = { @JoinColumn(name = "BK_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "GR_ID") })
    @JsonView({View.Main.class})
    @XmlElement(name = "book")
	private List<Genre> genre;
/*	
	public Book(final String name, final String isbn, final String writer, final List<Genre> genre) {
		this.name = name;
		this.isbn = isbn;
		this.writer = writer;
		this.genre = genre;
		locations = new ArrayList<Borrow>();
	}
	
	public Book() {
		
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
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Set<Borrow> getLocations() {
		return locations;
	}
	
	public void setLocations(Set<Borrow> locations) {
		this.locations = locations;
	}
	
	public List<Genre> getGenre() {
		return genre;
	}
	
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

}