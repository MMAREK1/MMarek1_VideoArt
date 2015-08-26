package sk.tsystems.akademia.VideoArt.Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review {
	/*
	 * datetime of creation (should be filled as automatic value
	 * using @PrePersist) - reviewed (VideoArt 0..1 master) - rating ( int 1 -
	 * 10 ) - text (max 5000 chars)
	 */
	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfCreation;
	@ManyToOne
	private VideoArt reviewed;
	private int rating;
	@Column(length=5000)
	private String text;
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	@PrePersist
	  protected void onCreate() {
		this.dateOfCreation = new Date();
	  }
	public void setText(String text) {
		this.text = text;
	}
	public VideoArt getReviewed() {
		return reviewed;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setReviewed(VideoArt reviewed) {
		this.reviewed = reviewed;
	}
	@Override
	public String toString() {
		return "Review [dateOfCreation=" + dateOfCreation + ", rating=" + rating + ", text=" + text + "]";
	}


	
}
