package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.stereotype.Repository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.Users.User;

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


@Repository
public interface CourseRepository {

    /**
     * Find a Course by id.
     *
     * @param id Of the course you want to find.
     * @return Optional Of the selected course.
     */
    Optional<Course> findById(Long id);


    /**
     * Find a Course by name.
     *
     * @param name Of the course you want to find.
     * @return List Of the selected courses.
     */
    List<Course> findByName(String name);

    /**
     * Find a Course by price.
     *
     * @param price Of the course you want to find.
     * @return List Of the courses with selected price.
     */
    List<Course> findByPrice(Double price);


    /**
     * Find a Course if free or charged.
     *
     * @param isFree If the course is free or not.
     * @return List Of free selected courses.
     */
    List<List> findByIsfree(Boolean isFree);


    /**
     * Find a Course by user.
     *
     * @param user Of the course you want to find.
     * @return List Of the selected courses.
     */
    List<Course> findByUser(User user);





}


