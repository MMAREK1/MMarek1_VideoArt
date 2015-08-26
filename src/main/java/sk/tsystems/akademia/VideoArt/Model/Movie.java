package sk.tsystems.akademia.VideoArt.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie extends VideoArt {
	/*
	 * publication date (first date of release in cinema - not time) 
	 * length  (in minutes)
	 */
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	private int length;
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Movie [publicationDate=" + publicationDate + ", length=" + length + ", getAdditionalInfo()="
				+ getAdditionalInfo() + ", getGenres()=" + getGenres() + ", getDirectors()=" + getDirectors()
				+ ", getActors()=" + getActors() + ", getReviews()=" + getReviews() + ", getName()=" + getName()
				+ ", getYearOfPublication()=" + getYearOfPublication() + "]";
	}


	
}
