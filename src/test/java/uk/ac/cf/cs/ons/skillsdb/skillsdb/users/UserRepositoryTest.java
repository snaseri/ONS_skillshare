package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository repository;

  private User user;

  @Before
  public void setup() {
    User user = new User();
            user.setId(1);
            user.setUsername("JohnDoe");
            user.setPassword("Password");
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

/*  @Test
  public void userCanBeChanged() {
    repository.save( user.setUsername("JohnDoe") );
    assertEquals( user, repository.findById(1L).get() );
  }*/

/*
  @Test
  public void userCanBeFoundByUsername() {
    repository.save( user.setUsername("John");
    repository.save( user.setUsername("Smith"));
    repository.save( user.setUsername("Rodger");

    assertEquals("Smith", repository.findByUsername("Smith").getUsername() );
  }
*/



}
