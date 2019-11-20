package uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews.Review;

public interface EnrolledFinder extends EnrolledRepository, JpaRepository<EnrolledOnCourse, Long> {
}
