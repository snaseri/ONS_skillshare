package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AdvertRepository allows for access to the Adverts data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 * @see     Advert
 * @url     https://spring.io/projects/spring-data-jpa
 */
@Repository
public interface AdvertRepository extends CrudRepository<Advert, Long> {
  // TODO: Add any needed queries here...

}
