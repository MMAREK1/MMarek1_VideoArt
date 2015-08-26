package sk.tsystems.akademia.VideoArt.Dao;

import java.util.List;

import sk.tsystems.akademia.VideoArt.JpaHelper;
import sk.tsystems.akademia.VideoArt.Model.Review;

public class ReviewDao {
	public void saveReview(Review review) {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(review);
		JpaHelper.getEntityManager().flush();
		JpaHelper.commitTransaction();
	}

	public void listAllReviews() {
		JpaHelper.beginTransaction();
		
		List<Review> reviews = JpaHelper.getEntityManager().createQuery("select c from Company c", Review.class)
				.getResultList();

		for (Review c : reviews) {
			System.out.println(c);
		}
		JpaHelper.commitTransaction();
	}
}
