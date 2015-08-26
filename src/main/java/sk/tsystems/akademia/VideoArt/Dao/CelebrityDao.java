package sk.tsystems.akademia.VideoArt.Dao;

import java.util.List;

import sk.tsystems.akademia.VideoArt.JpaHelper;
import sk.tsystems.akademia.VideoArt.Model.Celebrity;
import sk.tsystems.akademia.VideoArt.Model.VideoArt;

public class CelebrityDao {
	public void saveCelebrity(Celebrity celebrity) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(celebrity);
		JpaHelper.getEntityManager().flush();
		JpaHelper.commitTransaction();
	}

	public void listAllCelebrity() {
		JpaHelper.beginTransaction();
		
		List<Celebrity> celebrities = JpaHelper.getEntityManager().createQuery("select c from Company c", Celebrity.class)
				.getResultList();

		for (Celebrity c : celebrities) {
			System.out.println(c);
		}
		JpaHelper.commitTransaction();
	}

}
