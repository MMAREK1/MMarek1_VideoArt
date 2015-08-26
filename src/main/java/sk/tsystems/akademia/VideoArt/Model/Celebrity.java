package sk.tsystems.akademia.VideoArt.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Celebrity {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String surname;
	@Temporal(TemporalType.DATE)
	private Date dateOdfBirth;
	@Column(length=3000)
	private String biography;
	
	@ManyToMany(mappedBy="directors")
	private List<VideoArt> directed = new ArrayList<>();
	
	@ManyToMany(mappedBy="actors")
	private List<VideoArt> actedAt=new ArrayList<>();
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDateOdfBirth() {
		return dateOdfBirth;
	}
	public void setDateOdfBirth(Date dateOdfBirth) {
		this.dateOdfBirth = dateOdfBirth;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public List<VideoArt> getDirected() {
		return directed;
	}
	public List<VideoArt> getActedAt() {
		return actedAt;
	}
	public void addDirected(VideoArt videoArt) {
		directed.add(videoArt);
	}
	public void addActedAt(VideoArt videoArt) {
		actedAt.add(videoArt);
	}
	@Override
	public String toString() {
		return "Celebrity [firstName=" + firstName + ", surname=" + surname + ", dateOdfBirth=" + dateOdfBirth
				+ ", biography=" + biography + "]";
	}

	
}
