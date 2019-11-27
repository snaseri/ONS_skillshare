package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.model.User;

import java.time.LocalDateTime;


class CourseTest {

    private Course course;

    @Before
    public void setup() {
        course = new Course()
                .id(1)
                .name("Python")
                .description("teaching lots of python")
                .isFree(false)
                .price(50.00)
                .date(LocalDateTime.now())
                .user(new User());

    }

    @Test
    public void userCanChangeName() {
        assertEquals("Josh", course.name("Josh").name());
    }

    @Test
    public void userCanChangeDescripton() {
        assertEquals("Josh", course.description("Josh").description());
    }

    @Test
    public void userCanChangePrice() {
        assertEquals(50.50, course.price(50.50));
    }

}