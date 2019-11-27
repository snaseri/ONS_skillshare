package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.dao.UserDao;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository.UserRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Repository
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {


    @Autowired
    BCryptPasswordEncoder encoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserDao userDao;

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
    }


   /* @Override
    public UserDetails getUsername(String username) {

        User user = userDao.findUserByUsername(username);

        String currentusername = user.getUsername();


        return userRepository.findByUsername(username);
    }*/



    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public List<User> getUsers() {
        return userDao.getUserDetails();
    }


    @Override
    public long saveUser(User user) {


        user.setPassword(encoder.encode(user.getPassword()));
       /* userRepository.save(user);*/

            entityManager.persist(user);

            return user.getId();
    }




}







