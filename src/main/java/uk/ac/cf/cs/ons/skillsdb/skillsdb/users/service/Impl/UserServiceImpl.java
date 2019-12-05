package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository.UserRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {


    @Autowired
    BCryptPasswordEncoder encoder;

    @PersistenceContext
    private EntityManager entityManager;



    @Autowired
    UserRepository userRepository;




    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }





    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }




    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }




    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }




}







