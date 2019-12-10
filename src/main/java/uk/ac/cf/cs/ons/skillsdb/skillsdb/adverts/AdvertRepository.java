package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * AdvertRepository allows for access to the Adverts data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-07
 * @see     Advert
 * @url     https://spring.io/projects/spring-data-jpa
 */
@Repository
public interface AdvertRepository extends CrudRepository<Advert, Long> {

    /**
     * Find all Adverts where the title is like title.
     *
     * @param title
     * @return Optional
     */
    Optional<List<Advert>> findByTitleContains(String title);

}
