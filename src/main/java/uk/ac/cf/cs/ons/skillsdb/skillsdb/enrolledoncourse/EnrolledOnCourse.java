package uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse;

import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EnrolledOnCourse")
public class EnrolledOnCourse {

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
     * user who is enrolled on the course
     *
     *
     * @param user_creator new review for the Review.
     * @return the enrolled user.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private uk.ac.cf.cs.ons.skillsdb.skillsdb.Users.User user;



    /**
     * course who created and is running Review
     *
     *
     * @param course new course for the Review.
     * @return course that the Review is for.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

}
