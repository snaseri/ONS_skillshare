package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseFinder extends CourseRepository, JpaRepository<Course, Long> {
}
