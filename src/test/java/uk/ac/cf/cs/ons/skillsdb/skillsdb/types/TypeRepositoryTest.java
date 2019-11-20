package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTest {

  @Autowired
  private TypeRepository repository;

  private Type type;

  @Before
  public void setup() {
    type = new Type()
            .id(1)
            .name(AdvertType.ACCELERATION);
  }

  @Test
  public void canGetTypesFromDatabase() {
    assertEquals(type, repository.findById(1L).get() );
  }


}
