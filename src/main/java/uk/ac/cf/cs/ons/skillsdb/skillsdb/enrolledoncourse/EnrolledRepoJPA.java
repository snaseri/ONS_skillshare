package uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolledRepoJPA extends EnrolledRepository, JpaRepository<EnrolledOnCourse, Long> {

//    @Query(value = "select count(user_creator) from enrolled_on_course where course_id=(:paramSearch)", nativeQuery = true)
//    List<Enrolled> countByIdWh(@Param("paramSearch") String searchTerm);
//

}
