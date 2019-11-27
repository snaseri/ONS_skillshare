package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * User is a representation of a user of the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "Courses")
public class Course {

    /**
     * Id of the user.
     *
     * @param id New id for the user.
     * @return id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;



    /**
     * name of the course.
     *
     * @param name New name for the course.
     * @return name of the course.
     */
    @Column(name = "name")
    private String name;



    /**
     * description for the course.
     *
     *
     * @param description New description for the course.
     * @return description of the course.
     *
     */
    @Column(name = "description")
    private String description;


    /**
     * Boolean to see if course is free.
     *
     *
     * @param isFree Wether the course is free or not.
     * @return Wether the course is free or not.
     *
     */
    @Column(name = "is_free")
    private Boolean isFree;


    /**
     * The Price of the course.
     *
     *
     * @param price new price for the course.
     * @return the price for the course.
     *
     */
    @Column(name = "price")
    private Double price;



    /**
     * date that the course is going to be.
     *
     *
     * @param date new Date for the course.
     * @return date of the course.
     *
     */
    @Column(name = "date")
    private LocalDateTime date;

    /**
     * User who created and is running course
     *
     *
     * @param user_creator new User for the course.
     * @return user of the course.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private User user;


}
