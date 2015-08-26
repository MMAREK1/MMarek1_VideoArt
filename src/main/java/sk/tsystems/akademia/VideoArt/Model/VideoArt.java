package sk.tsystems.akademia.VideoArt.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public abstract class VideoArt {
	/*
	 * name year of publication (not date) genres (Genre 0..* master) -
	 * directors (Person 0..* master) actors (Person 0..* master) reviewsv
	 * (Review 0..* slave) additional info (List<String>)
	 */
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int yearOfPublication;

	@ManyToMany
	private List<Genre> genres = new ArrayList<>();
	@JoinTable(name="directors")
	@ManyToMany
	private List<Celebrity> directors = new ArrayList<>();
	@JoinTable(name="actors")
	@ManyToMany
	private List<Celebrity> actors = new ArrayList<>();

	@OneToMany(mappedBy="reviewed")
	private List<Review> reviews = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> additionalInfo = new ArrayList<>();

	public List<String> getAdditionalInfo() {
		return additionalInfo;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public List<Celebrity> getDirectors() {
		return directors;
	}

	public List<Celebrity> getActors() {
		return actors;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addDirectors(Celebrity director) {
		directors.add(director);
	}

	public void addReviews(Review review) {
		reviews.add(review);
	}

	public void addActors(Celebrity actor) {
		actors.add(actor);
	}

	public void addGenres(Genre genre) {
		genres.add(genre);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public List<String> getAdditionalinfo() {
		return additionalInfo;
	}

	public void addAdditionalinfo(String addInfo) {
		additionalInfo.add(addInfo);
	}

	@Override
	public String toString() {
		return "VideoArt [name=" + name + ", yearOfPublication=" + yearOfPublication + ", genres=" + genres
				+ ", directors=" + directors + ", actors=" + actors + ", reviews=" + reviews + ", additionalInfo="
				+ additionalInfo + "]";
	}
}
