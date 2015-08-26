package sk.tsystems.akademia.VideoArt.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
	/*
	 * name - description
	 */
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Column(length=1000)
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}

	
}
