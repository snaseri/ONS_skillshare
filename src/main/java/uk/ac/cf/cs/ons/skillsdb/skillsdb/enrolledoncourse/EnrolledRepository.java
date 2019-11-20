package uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews.Review;

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


public interface EnrolledRepository {

    /**
     * Find a Review by id.
     *
     * @param id Of the Enrolment you want to find.
     * @return Optional Of the selected review.
     */
    Optional<EnrolledOnCourse> findById(Long id);

}


