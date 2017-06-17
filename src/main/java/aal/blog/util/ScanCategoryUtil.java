package aal.blog.util;

import aal.blog.model.Category;
import aal.blog.model.Post;
import aal.blog.service.CategoryService;

public class ScanCategoryUtil {
    private static String path;

    public static String getPaths(CategoryService categoryService, Post post, long userId) {
        path = "";

        for (Category category : post.getCategory()) {
            String categoryPath = " > " + category.getName();
            long level = category.getLevel();
            long catParentId = category.getParentId();
            while (level != -1) {
                category = categoryService.findByParentIdThroughCategoryId(catParentId, userId);
                categoryPath = " > " + category.getName() + categoryPath;
                level = category.getLevel();
                catParentId = category.getCategoryId();
            }
            categoryPath = categoryPath.substring(3) + "<br>";
            path += categoryPath;
        }

        return path;
    }
}
