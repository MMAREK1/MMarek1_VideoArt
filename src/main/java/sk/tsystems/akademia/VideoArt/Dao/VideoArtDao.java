package sk.tsystems.akademia.VideoArt.Dao;

import java.util.List;

import javax.persistence.Query;

import sk.tsystems.akademia.VideoArt.JpaHelper;
import sk.tsystems.akademia.VideoArt.Model.Celebrity;
import sk.tsystems.akademia.VideoArt.Model.Movie;
import sk.tsystems.akademia.VideoArt.Model.VideoArt;

public class VideoArtDao {
	public void saveVideoArt(VideoArt videoArt) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(videoArt);
		JpaHelper.getEntityManager().flush();
		JpaHelper.commitTransaction();
	}

	public void listAllVideoArts() {
		JpaHelper.beginTransaction();
		
		List<VideoArt> videoArts = JpaHelper.getEntityManager().createQuery("select c from Company c", VideoArt.class)
				.getResultList();

		for (VideoArt c : videoArts) {
			System.out.println(c);
		}
		JpaHelper.commitTransaction();
	}
	
	public void showMovieFromYear(int year){
		List<VideoArt> movies = JpaHelper.getEntityManager().createQuery("SELECT m FROM Movie m where m.yearOfPublication= :year",VideoArt.class).
				setParameter("year", year).getResultList();
		for(VideoArt m : movies)
		{
			System.out.println(m);
			System.out.println("\n");
		}
	}
	
	public void countOfSerials(){
		Query query = JpaHelper.getEntityManager().createQuery("Select Count(*) FROM TvSeries");
		Long count = (Long)query.getSingleResult();
		System.out.println("Pocet Serialov:"+ count);
	}
	
	public void countOfMovies(){
		Query query = JpaHelper.getEntityManager().createQuery("Select Count(*) FROM Movie");
		Long count = (Long)query.getSingleResult();
		System.out.println("Pocet filmov:"+ count);
	}
	
	public void showMovieWithActor(String celebrity){
		List<VideoArt> movies = JpaHelper.getEntityManager().createQuery("SELECT m FROM VideoArt m join m.Celebrity c where c.surname= :celebrity",VideoArt.class).
				setParameter("celebrity", celebrity).getResultList();
		for(VideoArt m : movies)
		{
			System.out.println(m);
			System.out.println("\n");
		}
	}
}
