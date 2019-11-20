package uk.ac.cf.cs.ons.skillsdb.skillsdb.comments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentFinder extends CommentRepository, JpaRepository<Comment, Long> {
}
