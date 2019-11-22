package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course course;

    @Before
    public void setup() {
        course = new Course();
        course.setId(1);
        course.setName("Python");
        course.setDescription("teaching lots of python");
        course.setIsFree(false);
        course.setPrice(50.00);
        course.setDate(LocalDateTime.now());
        course.setUser(new User());

    }

    @Test
    public void userCanChangeName() {
      course.setName("Josh");
      assertEquals("Josh", course.getName());
    }

    @Test
    public void userCanChangeDescripton() {
      course.setDescription("Josh");
      assertEquals("Josh", course.getDescription());
    }

    @Test
    public void userCanChangePrice() {
      course.setPrice(50.50);
      assertEquals(50.50, course.getPrice(), 0);
    }

}