package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueries implements UserFinder {

    private UserRepository userRepository;

    public UserQueries(UserRepository repo) {

        userRepository = repo;
    }

    public Optional<User> findUserByIndex(Long index) {

        return userRepository.findById(index.longValue());

    }

    public List<User> findUserBySearch(String searchTerm){

        return userRepository.findByUsername(searchTerm);
    }

}
