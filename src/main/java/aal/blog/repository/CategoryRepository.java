package aal.blog.repository;

import aal.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import sun.plugin.cache.OldCacheEntry;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select category from ru.mrchebik.model.Category category where category.user.userId = :userId")
    List<Category> findAll(@Param("userId") long userId);

    @Query("select category from ru.mrchebik.model.Category category where category.categoryId = :parentId and category.user.userId = :userId")
    Category findByParentIdThroughCategoryId(@Param("parentId") long parentId, @Param("userId") long userId);

    @Query("select category from ru.mrchebik.model.Category category where category.parentId = :parentId and category.user.userId = :userId")
    List<Category> findByParentId(@Param("parentId") long parentId, @Param("userId") long userId);
}
