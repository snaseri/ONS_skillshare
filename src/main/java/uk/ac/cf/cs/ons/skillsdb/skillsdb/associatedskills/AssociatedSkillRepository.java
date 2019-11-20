package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
/**
 * AssociatedSkillRepository allows the caller to access to the associatedskills data source.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @see     AssociatedSkill
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
public interface AssociatedSkillRepository extends CrudRepository<AssociatedSkill, Long> {

    Optional<AssociatedSkill> findByUser(String user);
}
