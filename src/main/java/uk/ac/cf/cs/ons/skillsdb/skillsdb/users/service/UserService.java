package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.util.List;

public interface UserService {




    void save(User user);

    UserDetails loadUserByUsername(String username);

    User findByUsername(String username);
}

