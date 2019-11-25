package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import java.util.List;
import java.util.Optional;

public interface UserFinder {

    public Optional<User> findUserByIndex(Long index);

    public List<User> findUserBySearch(String searchTerm);
}
