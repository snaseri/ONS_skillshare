package uk.ac.cf.cs.ons.skillsdb.skillsdb.teams;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * TeamRepository allows the caller to access to the teams data source.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @see     Team
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
public interface TeamRepository extends CrudRepository<Team, Long> {

    Optional <Team> findByName(String name);
}
