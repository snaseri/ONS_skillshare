package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepoJPA extends UserRepository, CrudRepository<uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User, Long> {

    @Query(value = "select * from Users where upper(concat(username)) like concat('%', upper(:paramSearch), '%')", nativeQuery = true)
    List<User> findByUsername(@Param("paramSearch")String searchTerm);
}
