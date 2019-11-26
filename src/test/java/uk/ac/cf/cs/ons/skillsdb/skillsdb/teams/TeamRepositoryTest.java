package uk.ac.cf.cs.ons.skillsdb.skillsdb.teams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository repository;

    private Team team;

    @Before
    public void setup() {
        team = new Team();
        team.setId(1);
        team.setTeamName("TheTeam");
        team.setTeamDescription("TheBestTeam");
    }

    @Test
    public void teamInsert(){
        repository.save(team);
        assertEquals(team, repository.findById(1L).get());
    }

    @Test
    public void deleteTeam(){
        repository.delete(team);
        assertFalse(repository.findById(1L).isPresent());
    }

    @Test
    public void foundTeam(){

        Team a = new Team();
        Team b = new Team();
        Team c = new Team();

        a.setTeamName("Team A");
        b.setTeamName("Team B");
        c.setTeamName("Team C");

        repository.save(a);
        repository.save(b);
        repository.save(c);

        assertEquals( c.getTeamName(), repository.findByTeamName("Team C").get().getTeamName() );
    }
}
