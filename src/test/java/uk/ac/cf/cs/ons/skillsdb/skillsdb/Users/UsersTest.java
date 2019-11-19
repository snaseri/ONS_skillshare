package uk.ac.cf.cs.ons.skillsdb.skillsdb.Users;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UsersTest {

  private User user;

  @Before
  public void setup() {
    user = new User()
            .id(1)
            .username("JohnDoe")
            .password("Password");

  }

  @Test
  public void userCanChangeId() {
    assertEquals( 2, user.id(2).id() );
  }

  @Test
  public void userCanChangePassword() {
    assertEquals("Password1", user.password("Password1").password() );
  }

  @Test
  public void userCanChangeUsername() {
    assertEquals("JonDoe", user.username("JonDoe").username() );
  }


}
