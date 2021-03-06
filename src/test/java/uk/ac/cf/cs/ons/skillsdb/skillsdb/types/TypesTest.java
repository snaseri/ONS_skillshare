package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypesTest {

    private Type type;

    @Before
    public void setup() {
      type = new Type()
              .id(1)
              .name(AdvertType.ADVICE);
    }

    @Test
    public void typeIdCanChange() {
      type.id(2);
      assertEquals( 2, type.id() );
    }

    @Test
    public void typeAdvertTypeCanChange() {
      type.name(AdvertType.ASSISTANCE);
      assertEquals(AdvertType.ASSISTANCE, type.name());
    }

}
