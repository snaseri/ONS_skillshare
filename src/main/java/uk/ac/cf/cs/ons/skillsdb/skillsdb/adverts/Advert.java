package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Advert represents an Advertisement that a User can post
 * for Acceleration, Tutoring, Advice, Assistance.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 */
@Data
@Entity
@Table(name = "Adverts")
public class Advert {

  /**
   * Id of the Advert.
   *
   * @param id New id of Advert.
   * @return id of Advert.
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /**
   * User Id of the Advert. User {@see User} that created the Advert.
   *
   * @param userId, New user id of the Advert.
   * @return user id of the Advert.
   */
  @Column(name = "user_creator")
  private long userId;

  /**
   * Skill Id of the Advert. Skill {@see Skill} that the Advert aims to teach.
   *
   * @param skillId, New skill id of the Advert.
   * @return skill id of Advert.
   */
  @Column(name = "skill_id")
  private long skillId;

  /**
   * Type Id of the Advert. Type that the Advert is, {@see Type}.
   *
   * @param typeId, New type id of the Advert.
   * @return type id of the Advert.
   */
  @Column(name = "type_id")
  private long typeId;

  /**
   * Title of the Advert. e.g Python: 101
   *
   * @param name, New name of the Advert.
   * @return name of Advert.
   */
  @Column(name = "name")
  private String title;

  /**
   * Description of the Advert. e.g Python for Beginners
   *
   * @param description, New description of Advert.
   * @return description of Advert.
   */
  private String description;

  /**
   * Date, and Time that the Advert was posted
   *
   * @param posted, New DateTime that Advert was posted.
   * @return posted DateTime of Advert.
   */
  private LocalDateTime posted;

}

