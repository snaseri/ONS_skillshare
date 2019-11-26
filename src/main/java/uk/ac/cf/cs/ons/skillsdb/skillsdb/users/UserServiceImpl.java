package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * UserServiceImpl is an implementation of {@see UserService} allowing controlled access to the UserRepository.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-26
 * @see     User
 * @see     UserService
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    /**
     * Allows for an implementation of UserService to be created with an implementation of UserRepository.
     * 
     * @param repository, implementation of UserRepository.
     */
    public UserServiceImpl(UserRepository repository) {
        userRepository = repository;
    }

    /**
     * Find a User by their unique id.
     *
     * @param id, Users id
     * @return Optional of user
     */
    @Override
    public Optional<User> findUserByIndex(long id) {
        return userRepository.findById(id);
    }

    /**
     * Find a User(s) by similar username(s).
     *
     * @param searchTerm, Users usernames.
     * @return Optional of a list of potentially matching users.
     */
    @Override
    public Optional<List<User>> findUserBySearch(String searchTerm){
        return userRepository.findByUsernameContains(searchTerm);
    }

}
