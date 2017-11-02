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
@Table(name="BK_BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BK_ID")
	@JsonView(View.All.class)
	private Long id;
	
	@Column(name="BK_NAME", unique=true, length=50, nullable=false)
	@JsonView({View.Main.class, View.Alternative.class})
	private String name;
	
	@Column(name="BK_ISBN", unique=true, length=20)
	@JsonView({View.Main.class, View.Alternative.class})
	private String isbn;
	
	@Column(name="BK_WRITER", unique=true, length=50)
	@JsonView({View.Main.class, View.Alternative.class})
	private String writer;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BRW_BORROW", 
    	joinColumns = { @JoinColumn(name = "BK_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "USR_ID") })
    @JsonView({View.Main.class, View.Alternative.class})
    @XmlElement(name = "book")
	private List<User> locations;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BKGR_BOOK_GENRE", 
    	joinColumns = { @JoinColumn(name = "BK_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "GR_ID") })
    @JsonView({View.Main.class, View.Alternative.class})
    @XmlElement(name = "book")
	private List<Genre> genre;
	
	public Book(final String name, final List<Genre> genre) {
		this.name = name;
		this.genre = genre;
	}
	
	public Book() {
		
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

	public List<User> getLocationsBooks() {
		return locations;
	}
	
	public void setLocations(List<User> locationsBooks) {
		this.locations = locationsBooks;
	}
	
	public List<Genre> getGenre() {
		return genre;
	}
	
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

}