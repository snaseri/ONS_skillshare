package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedteams;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.teams.Team;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * AssociatedTeam is a representation of a user and a team of the SkillsDB.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "associatedteams")
public class AssociatedTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "left_team")
    private LocalDateTime leftTeam;

}
