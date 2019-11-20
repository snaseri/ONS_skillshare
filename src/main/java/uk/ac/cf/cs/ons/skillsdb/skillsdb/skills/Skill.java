package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Skill represents a Skill a User, Comment, or Advert could have or require.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 */
@Data
public class Skill {

  /**
   * Id of Skill.
   *
   * @param id New id of Skill.
   * @return id of Skill.
   */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /**
   * Name of Skill.
   *
   * @param name New name of Skill.
   * @return name of Skill.
   */
  private String name;

  /**
   * Description of the Skill.
   *
   * @param description New description of Skill.
   * @return description of Skill.
   */
  private String description;


}
