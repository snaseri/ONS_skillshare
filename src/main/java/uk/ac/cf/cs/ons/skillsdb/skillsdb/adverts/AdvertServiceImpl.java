package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.exceptions.AdvertNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * AdvertServiceImpl is the implementation of {@see AdvertService}.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 * @see     Advert
 * @see     AdvertRepository
 */
@Log
@Service
public class AdvertServiceImpl implements AdvertService {

  private AdvertRepository repository;

  /**
   * Allows for Creation of an AdvertService through Depenency Injection (DI) by injecting
   * a implementation of the AdvertRepository.
   *
   * @param repository AdvertRepository data source.
   */
  @Autowired
  public AdvertServiceImpl(AdvertRepository repository) {
    this.repository = repository;
  }

  /**
   * Save Advert to the repository.
   *
   * @param advert
   */
  @Override
  public void createAdvert(Advert advert) {
    log.info("Create Advert: " + advert);

    // TODO: This should be automatic when users are created.
    advert.setUserId(1);
    advert.setPosted(LocalDateTime.now());
    repository.save(advert);
  }

  /**
   * Update an Advert with a specfied id...
   *
   * @param id of Advert you want to update
   * @param advert, Advert with information you want to update.
   * @throws AdvertNotFoundException if Advert is not found
   */
  @Override
  public void updateAdvert(long id, Advert advert) throws AdvertNotFoundException {
    log.info("Update Advert with id: " + id + " "  + advert );
    repository.save(repository
            .findById(id)
            .orElseThrow( () -> new AdvertNotFoundException("Cant update Advert. Advert with id: " + id + " not found.") ));
  }

  /**
   * Delete an Advert with a specfied id...
   *
   * @param id id of Advert you want to delete
   * @throws AdvertNotFoundException if Advert is not found
   */
  @Override
  public void deleteAdvert(long id) throws AdvertNotFoundException {
    log.info("Delete Advert with id: " + id);
    repository.save( repository
            .findById(id)
            .orElseThrow( () -> new AdvertNotFoundException("Cant delete Advert. Advert with id: " + id + " not found.")) );
  }

  /**
   * Get all Adverts
   *
   * @return list of all Adverts
   */
  @Override
  public Optional<Iterable<Advert>> getAdverts() {
    return Optional.of( repository.findAll() );
  }

  /**
   * Return an Advert by it'sid
   *
   * @param id of Advert
   * @return advert
   * @throws AdvertNotFoundException if Advert is not found
   */
  @Override
  public Optional<Advert> readAdvert(long id) throws AdvertNotFoundException {
    return Optional.of(repository.findById(id)
                    .orElseThrow( () -> new AdvertNotFoundException("Cant find Advert. Advert with id: " + id  + " not found.")) );
  }

  @Override
  public List<Advert> findAllBySkillIdName(String name) {
    return repository.findAllBySkillIdName(name);
  }


}
