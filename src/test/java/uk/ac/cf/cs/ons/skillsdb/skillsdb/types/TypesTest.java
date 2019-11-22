package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypesTest {

    private Type type;

    @Before
    public void setup() {
      type = new Type();
      type.setId(1);
      type.setName(AdvertType.ADVICE);
    }

    @Test
    public void typeIdCanChange() {
      type.setId(2);
      assertEquals( 2, type.getId() );
    }

    @Test
    public void typeAdvertTypeCanChange() {
      type.setName(AdvertType.ASSISTANCE);
      assertEquals(AdvertType.ASSISTANCE, type.getName());
    }

}
