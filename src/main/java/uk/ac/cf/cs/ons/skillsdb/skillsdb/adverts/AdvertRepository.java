package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> d71bf734df2a45a23e40f25c1290d9be5809f1a1

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
<<<<<<< HEAD

    /**
     * Find all Adverts where the title is like title.
     *
     * @param title
     * @return Optional
     */
    Optional<List<Advert>> findByTitleContains(String title);

=======
  // TODO: Add any needed queries here...

    List<Advert> findAllBySkillIdName(String name);
>>>>>>> d71bf734df2a45a23e40f25c1290d9be5809f1a1
}
