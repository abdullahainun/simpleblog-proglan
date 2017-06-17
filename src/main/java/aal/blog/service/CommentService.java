package aal.blog.service;

import org.springframework.security.access.prepost.PreAuthorize;
import aal.blog.model.Comment;

import java.util.List;

public interface CommentService {
    @PreAuthorize("hasRole('ROLE_USER')")
    Comment add(Comment comment);

    @PreAuthorize("hasRole('ROLE_USER')")
    Comment findById(long id);

    @PreAuthorize("hasRole('ROLE_USER')")
    List<Comment> findComments(long id);

    @PreAuthorize("hasRole('ROLE_USER')")
    void remove(long id);
}
