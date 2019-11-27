package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

import java.util.List;

public interface UserService {



    List<User> getUsers();

    long saveUser(User user);

    UserDetails loadUserByUsername(String username);
}
