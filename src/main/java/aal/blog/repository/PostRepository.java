package aal.blog.repository;

import aal.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select post from ru.mrchebik.model.Post post where post.user.userId = :userId")
    List<Post> findByUser(@Param("userId") long id);

    @Query("select max(post.postId) from ru.mrchebik.model.Post post where post.user.userId = :userId")
    long findLastPostId(@Param("userId") long id);
}
