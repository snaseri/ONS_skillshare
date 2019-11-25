package uk.ac.cf.cs.ons.skillsdb.skillsdb.Users;

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
    user = new User()
            .id(1)
            .username("JohnDoe")
            .password("Password");
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
    repository.save( user.username("JohnDoe") );

    assertEquals( user, repository.findById(1L).get() );
  }

  @Test
  public void userCanBeFoundByUsername() {

    repository.save(new User()
            .id(2)
            .username("Smith")
            .password("Password1"));

    repository.save(new User()
            .id(3)
            .username("John")
            .password("Password2"));

    repository.save(new User()
            .id(4)
            .username("Davies")
            .password("Password3"));

    Optional<User> usr = repository.findByUsername("Smith");

    assertEquals( "Smith", usr.get().username() );
  }



}
