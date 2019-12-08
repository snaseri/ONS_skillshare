package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.exceptions.AdvertNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * AdvertService defines a Contract for AdvertServices to implement...
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 * @see     Advert
 * @see     AdvertServiceImpl
 */
public interface AdvertService {

  /**
   * Save Advert to the repository.
   *
   * @param advert
   */
  void createAdvert(Advert advert);

  /**
   * Return an Advert by it'sid
   *
   * @param id of Advert
   * @return advert
   * @throws AdvertNotFoundException if Advert is not found
   */
  Optional<Advert> readAdvert(long id) throws AdvertNotFoundException;

  /**
   * Update an Advert with a specfied id...
   *
   * @param id of Advert you want to update
   * @param advert, Advert with information you want to update.
   * @throws AdvertNotFoundException if Advert is not found
   */
  void updateAdvert(long id, Advert advert) throws AdvertNotFoundException;

  /**
   * Delete an Advert with a specfied id...
   *
   * @param id id of Advert you want to delete
   * @throws AdvertNotFoundException if Advert is not found
   */
  void deleteAdvert(long id) throws AdvertNotFoundException;

  /**
   * Get all Adverts
   *
   * @return list of all Adverts
   */
  Optional<Iterable<Advert>>  getAdverts();

  List<Advert> findAllBySkillIdName (String name);

}
