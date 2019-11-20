package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository allows the caller to access to the Users data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     Review
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface ReviewRepository {

    /**
     * Find a Review by id.
     *
     * @param id Of the review you want to find.
     * @return Optional Of the selected review.
     */
    Optional<Review> findById(Long id);


    /**
     * Find a Review by name.
     *
     * @param title Of the review you want to find.
     * @return List Of the selected courses.
     */
    List<Review> findByTitle(String title);

    /**
     * Find a Review by price.
     *
     * @param  description the review you want to find.
     * @return List Of the courses with the given description.
     */
    List<Review> findByDescription(String description);


}


