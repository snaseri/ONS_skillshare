package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.uuserdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;

/**
 * User is a representation of a user of the SkillsDB.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */




@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotEmpty
  @Column(nullable = false, unique = true)
  private String username;
  @NotEmpty
  private String password;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}