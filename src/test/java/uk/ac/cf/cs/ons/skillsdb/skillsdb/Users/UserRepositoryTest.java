package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository repository;

  private User user;

  @Before
  public void setup() {
    user = new User();
    user.setId(1);
    user.setUsername("JohnDoe");
    user.setPassword("Password");
  }

  @Test
  public void userCanBeInserted() {
    repository.save(user);

    Optional<User> usr = repository.findById(1L);

    assertEquals(user, usr.get() );
  }

  @Test
  public void userCanBeDeleted() {
    repository.delete(user);
    assertFalse( repository.findById(1L).isPresent() );
  }

  @Test
  public void userCanBeChanged() {
    user.setUsername("JohnDope");
    repository.save(user);

    assertEquals(user.getUsername(), repository.findById(1L).get().getUsername() );
  }

  @Test
  public void userCanBeFoundByUsername() {

    User u1 = new User();
    User u2 = new User();
    User u3 = new User();

    u1.setId(1);
    u2.setId(2);
    u3.setId(3);

    u1.setUsername("User1");
    u2.setUsername("User2");
    u3.setUsername("User3");

    u1.setPassword("Password1");
    u2.setPassword("Password2");
    u3.setPassword("Password3");

    repository.save(u1);
    repository.save(u2);
    repository.save(u3);

    Optional<User> usr = repository.findByUsername("User3");

    assertEquals("User3", usr.get().getUsername() );
  }

}
