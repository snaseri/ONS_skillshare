package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.dao;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUserDetails();
    User findUserByUsername(String username);


    void saveUser(User user);

}
