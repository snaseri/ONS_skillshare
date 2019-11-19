package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypesTest {

    private Type type;

    @Before
    public void setup() {
      type = new Type()
              .id(1L)
              .name(AdvertType.ADVICE);
    }

    @Test
    public void typeIdCanChange() {
      type.id(2L);
      assertEquals( 2L, type.id() );
    }

    @Test
    public void typeAdvertTypeCanChange() {
      type.name(AdvertType.ASSITANCE);
      assertEquals(AdvertType.ASSITANCE, type.name());
    }

}
