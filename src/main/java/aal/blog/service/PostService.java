package aal.blog.service;

import org.springframework.security.access.prepost.PreAuthorize;
import aal.blog.model.Post;

import java.util.List;


public interface PostService {
    @PreAuthorize("hasRole('ROLE_USER')")
    Post add(Post post);

    @PreAuthorize("hasRole('ROLE_USER')")
    long findLastPostId(long userId);

    @PreAuthorize("hasRole('ROLE_USER')")
    Post findPost(long postId);

    @PreAuthorize("hasRole('ROLE_USER')")
    List<Post> findPosts(long userId);

    @PreAuthorize("hasRole('ROLE_USER')")
    void remove(long id);
}
