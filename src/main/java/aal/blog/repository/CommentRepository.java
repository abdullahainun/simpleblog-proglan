package aal.blog.repository;

import aal.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select comment from ru.mrchebik.model.Comment comment where comment.post.postId = :postId")
    List<Comment> findByUser(@Param("postId") long id);
}
