package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedteams;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * AssociatedTeamRepository allows the caller to access to the associatedteams data source.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @see     AssociatedTeam
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
public interface AssociatedTeamRepository extends CrudRepository<AssociatedTeam, Long> {

    Optional<AssociatedTeam> findByUser(String user);
}
