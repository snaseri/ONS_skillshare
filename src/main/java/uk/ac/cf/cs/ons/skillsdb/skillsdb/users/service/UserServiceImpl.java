package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.Role;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repositories.RoleRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public boolean isUserAlreadyPresent(User user) {
        boolean isUserAlreadyExists = false;
        User existingUser = userRepository.findByUsername(user.getUsername());
        // If user is found in database, then then user already exists.
        if(existingUser != null){
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }
}
