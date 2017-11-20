package personallibrary.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import personallibrary.view.View;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "BRW_BORROW")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRW_ID")
	private Long id;
	
	@Column(name="BRW_START_DATE", nullable=true)
	@JsonView({View.All.class, View.Alternative.class})
	private LocalDate startDate;
	
	@Column(name="BRW_END_DATE", nullable=true)
	@JsonView({View.All.class, View.Alternative.class})
	private LocalDate endDate;
	
	@Column(name="BRW_STATUS", nullable=true)
	@JsonView({View.All.class, View.Alternative.class})
	private String status;
	
	//Validar o OneToOne, está ManyToOne
	@ManyToOne
	@JoinColumn(name="BK_ID", referencedColumnName="BK_ID")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="USR_ID", referencedColumnName="USR_ID")
	private User user;
	
	public Borrow (final String status, final LocalDate startDate, final LocalDate endDate, final Book book, final User user) {
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.book = book;
		this.user = user;
	}
	
	public Borrow() {
		
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public User getUser() {
		return user;
	}
}