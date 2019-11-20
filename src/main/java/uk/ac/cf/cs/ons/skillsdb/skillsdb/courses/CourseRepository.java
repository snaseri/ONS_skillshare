package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository allows the caller to access to the Users data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     Course
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface CourseRepository {

    /**
     * Find a Comment by id.
     *
     * @param id Of the course you want to find.
     * @return Optional Of the selected course.
     */
    Optional<Course> findById(Long id);


    /**
     * Find a Comment by name.
     *
     * @param name Of the course you want to find.
     * @return List Of the selected courses.
     */
    List<Course> findByName(String name);

    /**
     * Find a Comment by price.
     *
     * @param price Of the course you want to find.
     * @return List Of the courses with selected price.
     */
    List<Course> findByPrice(Double price);


}


