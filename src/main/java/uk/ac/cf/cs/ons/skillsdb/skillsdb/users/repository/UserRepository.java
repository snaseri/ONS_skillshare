package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


    public User findByUsername(String username);
}
