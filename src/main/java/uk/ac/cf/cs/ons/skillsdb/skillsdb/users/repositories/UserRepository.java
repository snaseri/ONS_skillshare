package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    public User findByUsername(String username);
}
