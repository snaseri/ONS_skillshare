package uk.ac.cf.cs.ons.skillsdb.skillsdb.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepository allows the caller to access to the Users data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @see     User
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * Find a User by username.
   *
   * @param username Of the user you want to find.
   * @return Optional Of the selected user.
   */
  Optional<User> findByUsername(String username);

}
