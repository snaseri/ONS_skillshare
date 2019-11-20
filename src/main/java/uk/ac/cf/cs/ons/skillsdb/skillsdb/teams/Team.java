package uk.ac.cf.cs.ons.skillsdb.skillsdb.teams;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String teamName;

    @Column(name = "description")
    private String teamDescription;

}
