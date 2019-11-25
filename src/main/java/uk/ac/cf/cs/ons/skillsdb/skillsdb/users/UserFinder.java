package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import java.util.Optional;

public interface UserFinder {

    public Optional<User> findUserByindex(Long index);

    public Optional<User> findUserBySearch(String searchTerm);
}
