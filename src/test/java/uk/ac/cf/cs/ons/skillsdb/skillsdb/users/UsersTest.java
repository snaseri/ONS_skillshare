package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersTest {

  private User user;

  @Before
  public void setup() {
    user = new User();
    user.setId(1);
    user.setUsername("JohnDoe");
    user.setPassword("Password");
  }

  @Test
  public void userCanChangeId() {
    int newId = 2;
    user.setId(newId);
    assertEquals( newId, user.getId() );
  }

  @Test
  public void userCanChangePassword() {
    String newPassword = "Password1";
    user.setPassword(newPassword);
    assertEquals( newPassword, user.getPassword() );
  }

  @Test
  public void userCanChangeUsername() {
    String newUsername = "JohnDoep";
    user.setUsername(newUsername);
    assertEquals( newUsername, user.getUsername() );
  }


}
