package personallibrary.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "BRW_BORROW")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRW_ID")
	private Long id;
	
	@Column(name="BRW_START_DATE", nullable=true)
	@JsonView({View.All.class, View.Alternative.class})
	private Date startDate;
	
	@Column(name="BRW_END_DATE", nullable=true)
	@JsonView({View.All.class, View.Alternative.class})
	private Date endDate;
	
	@OneToMany
	@JoinColumn(name="BK_ID", referencedColumnName="BK_ID")
	private Book book;
	
	@OneToMany
	@JoinColumn(name="USR_ID", referencedColumnName="USR_ID")
	private User user;
	
	public Borrow (final long bookId, final long userId, final LocalDate startDate, final LocalDate endDate) {
		
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}	
}