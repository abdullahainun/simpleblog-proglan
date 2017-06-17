package aal.blog.service;

import aal.blog.model.User;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {
    User add(User user);

    @PreAuthorize("hasRole('ROLE_USER')")
    void changeUsername(String email, String username);

    void changePassword(String email, String password);

    @PreAuthorize("hasRole('ROLE_USER')")
    void changeEmail(String email, String newEmail);

    @PreAuthorize("hasRole('ROLE_USER')")
    User findById(long userId);

    User findByEmail(String email);

    @PreAuthorize("hasRole('ROLE_USER')")
    User findByUsername(String username);

    @PreAuthorize("hasRole('ROLE_USER')")
    void remove(long id);
}
