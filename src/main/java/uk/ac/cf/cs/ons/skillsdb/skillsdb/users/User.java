package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import lombok.Data;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * User is a representation of a user of the SkillsDB.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Data
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  /**
   * Id of the user.
   *
   * @param id New id for the user.
   * @return id of the user.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Username of the user.
   *
   * @param username New username for the user.
   * @return username of the user.
   */
  @Column(name = "username")
  private String username;

  /**
   * Password of the user.
   *
   * TODO: This probably shouldn't be a String.
   *
   * @param password New password for the user.
   * @return password of the user.
   *
   */
  @Column(name = "password")
  private String password;

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Column(name = "active")
  private int active;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;


  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }



}
