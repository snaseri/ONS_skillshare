package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;

import javax.persistence.*;

/**
 * review is a representation of a review of the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "Reviews")
public class Review {

    /**
     * Id of the review.
     *
     * @param id New id for the review.
     * @return id of the review.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;



    /**
     * name of the Review.
     *
     * @param title New title for the Review.
     * @return title of the Review.
     */
    @Column(name = "title")
    private String title;



    /**
     * description for the Review.
     *
     *
     * @param description New description for the Review.
     * @return description for the Review.
     *
     */
    @Column(name = "description")
    private String description;


    /**
     * review who created and is running Review
     *
     *
     * @param course new course for the Review.
     * @return course that the Review is for.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;


    /**
     * review who created and is running Review
     *
     *
     * @param review_creator new review for the Review.
     * @return review of the Review.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User user;


}
