package aal.blog.repository;

import aal.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from ru.mrchebik.model.User where username = :username")
    User findByName(@Param("username") String username);

    @Modifying(clearAutomatically = true)
    @Query("update ru.mrchebik.model.User u set u.password = :password where u.userId = :userId")
    void changePassword(@Param("userId") long userId, @Param("password") String password);

    @Query("from ru.mrchebik.model.User where email = :email")
    User findByEmail(@Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Query("update ru.mrchebik.model.User u set u.username = :username where u.email = :email")
    void changeUsername(@Param("email") String email, @Param("username") String username);

    @Modifying(clearAutomatically = true)
    @Query("update ru.mrchebik.model.User u set u.email = :newEmail where u.email = :email")
    void changeEmail(@Param("email") String email, @Param("newEmail") String newEmail);
}
