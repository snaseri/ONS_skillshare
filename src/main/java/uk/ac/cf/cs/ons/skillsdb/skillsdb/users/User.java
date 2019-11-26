package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotEmpty
  @Column(nullable = false, unique = true)
  private String username;
  @NotEmpty
  private String password;

    @Column(name = "status")
    private String status;





    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}