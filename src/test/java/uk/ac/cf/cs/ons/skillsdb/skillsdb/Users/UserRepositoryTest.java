package uk.ac.cf.cs.ons.skillsdb.skillsdb.Users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    assertEquals( user, repository.findById(1L).get() );
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
    repository.save( user.username("John") );
    repository.save( user.username("Smith") );
    repository.save( user.username("Rodger") );

    assertEquals("Smith", repository.findByUsername("Smith").get() );
  }



}
