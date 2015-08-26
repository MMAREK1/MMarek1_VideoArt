package sk.tsystems.akademia.VideoArt.Model;

import javax.persistence.Entity;

@Entity
public class TvSeries extends VideoArt {
	/*
	 * series count - episode count - start year - end year
	 */
	private int seriesCount;
	private int episodeCount;
	private int endYear;
	public int getSeriesCount() {
		return seriesCount;
	}
	public void setSeriesCount(int seriesCount) {
		this.seriesCount = seriesCount;
	}
	public int getEpisodeCount() {
		return episodeCount;
	}
	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public void setEndYear() {
		this.endYear = 0;
	}
	@Override
	public String toString() {
		return "TvSeries [seriesCount=" + seriesCount + ", episodeCount=" + episodeCount + ", endYear=" + endYear
				+ ", getAdditionalInfo()=" + getAdditionalInfo() + ", getGenres()=" + getGenres() + ", getDirectors()="
				+ getDirectors() + ", getActors()=" + getActors() + ", getReviews()=" + getReviews() + ", getName()="
				+ getName() + ", getYearOfPublication()=" + getYearOfPublication() + "]";
	}

}
