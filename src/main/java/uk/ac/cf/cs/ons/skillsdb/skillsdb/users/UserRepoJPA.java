package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepoJPA extends UserRepository, CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM Users WHERE UPPER(username) LIKE UPPER(:paramSearch)", nativeQuery = true)
    List<User> findByUsername(@Param("paramSearch") String searchTerm);
}
