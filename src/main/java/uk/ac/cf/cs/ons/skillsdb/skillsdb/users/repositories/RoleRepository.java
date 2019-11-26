package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRole(String role);
}
