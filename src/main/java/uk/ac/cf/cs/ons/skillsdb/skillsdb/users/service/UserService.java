package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

public interface UserService {

    public void saveUser(User user);

    public boolean isUserAlreadyPresent(User user);
}
