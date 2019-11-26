package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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

    assertEquals( user, usr.get() );
  }

  @Test
  public void userCanBeDeleted() {
    repository.delete(user);

    assertFalse( repository.findById(1L).isPresent() );
  }

  @Test
  public void userCanBeChanged() {
    user.setUsername("JohnDoe");
    repository.save( user );

    assertEquals( user, repository.findById(1L).get() );
  }

  @Test
  public void userCanBeFoundByUsername() {

    User userA = new User();
    User userB = new User();
    User userC = new User();

    userA.setUsername("John");
    userB.setUsername("Mark");
    userC.setUsername("Jay");

    userA.setPassword("Password1");
    userB.setPassword("Password2");
    userC.setPassword("Password3");

    repository.save(userA);
    repository.save(userB);
    repository.save(userC);

    Optional<User> usr = repository.findByUsername("John");

    assertEquals ("John", usr.get().getUsername() );
  }

  @Test
  public void userCanBeFoundById() {
    repository.save(user);

    Optional<User> usr = repository.findById(1L);
    assertEquals(user, usr.get());

  }

  @Test
  public void usersCanBeFoundByUsernames() {

    // Inside Data there are two users called Robert, and Rob, this query should return both.

    Optional<List<User>> users = repository.findByUsernameContains("Rob");
    assertTrue( users.isPresent() && users.get().size() == 2 );


  }

}
