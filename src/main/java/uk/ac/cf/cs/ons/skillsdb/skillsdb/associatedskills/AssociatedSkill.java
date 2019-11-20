package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;
/**
 * AssociatedSkills is a representation of a user and a skill of the SkillsDB.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "associatedskills")
public class AssociatedSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "rating")
    private int rating;

}
