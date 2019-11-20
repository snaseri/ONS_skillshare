package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkillTest {

  private Skill skill;

  @Before
  public void setup() {
    skill = new Skill()
            .id(1)
            .name("Java")
            .description("Programming with Java 11");
  }

  @Test
  public void skillCanHaveIdChanged() {
    int newId = 2;
    assertEquals( newId, skill.id(newId).id() );
  }

  @Test
  public void skillCanHaveNameChanged() {
    String newName = "Python";
    assertEquals( newName, skill.name(newName).name() );
  }

  @Test
  public void skillCanHaveDescriptionChanged() {
    String newDesc = "Programming with Python 3.7";
    assertEquals(newDesc, skill.description(newDesc).description() );
  }


}
