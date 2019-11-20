package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewFinder extends ReviewRepository, JpaRepository<Review, Long> {
}
