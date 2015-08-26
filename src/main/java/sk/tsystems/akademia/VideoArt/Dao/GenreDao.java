package sk.tsystems.akademia.VideoArt.Dao;

import java.util.List;

import sk.tsystems.akademia.VideoArt.JpaHelper;
import sk.tsystems.akademia.VideoArt.Model.Genre;

public class GenreDao {
	public void saveGenre(Genre genre) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(genre);
		JpaHelper.getEntityManager().flush();
		JpaHelper.commitTransaction();
	}

	public void listAllGenres() {
		JpaHelper.beginTransaction();
		
		List<Genre> genres = JpaHelper.getEntityManager().createQuery("select c from Company c", Genre.class)
				.getResultList();

		for (Genre c : genres) {
			System.out.println(c);
		}
		JpaHelper.commitTransaction();
	}
}
